#!/usr/bin/env node

const fs = require('fs')
const path = require('path')
const chalk = require('chalk')
const {rmdirRecursive} = require('./utils')

function findSuperClassName(content) {
  const arr = content.match(/implements\s+(.*?)\s+/, content)
  return arr && arr[1]
}

function findClassName(content) {
  const arr = content.match(/class\s+(.*?)\s+/, content)
  return arr && arr[1]
}

function findJavaAttributes(content) {
  const attrs = []
  const attrReg = /(?:public|private)\s+([a-zA-Z]+)(\s*\[\])?\s+([a-zA-z0-9_,\s]+);/
  const arr = content.match(new RegExp(attrReg, 'g'))
  arr && arr.forEach(item => {
    const p = attrReg.exec(item).slice(1)
    const type = p[0]
    const isArray = !!p[1]
    const names = p[2].replace(/\s+/, '').split(',')
    names.forEach(name => {
      attrs.push({
        type,
        name,
        isArray
      })
    })
  })

  return attrs
}

function getTSAttributes(javaAttrs) {
  const attrs = []
  const mapper = {
    'byte': 'number',
    'short': 'number',
    'int': 'number',
    'long': 'number',
    'float': 'number',
    'double': 'number',
    'boolean': 'boolean',
    'char': 'string',
    
    'Byte': 'number',
    'Short': 'number',
    'Integer': 'number',
    'Long': 'number',
    'Float': 'number',
    'Double': 'number',
    'Boolean': 'boolean',
    'Character': 'string',

    'String': 'string'
  }
  javaAttrs.forEach(item => {
    attrs.push({
      type: mapper[item.type] || item.type,
      name: item.name,
      isArray: item.isArray
    })
  })

  return attrs
}

function transform(src, dist) {
  // 如果src 是一个目录
  const stats = fs.statSync(src)
  if (stats.isDirectory()) {

    // 如果存在的话 就清空目录
    if(fs.existsSync(dist)) {
      rmdirRecursive(dist)
    }

    fs.mkdirSync(dist, {recursive: true})

    const nodes = fs.readdirSync(src)
    nodes.forEach(node => {
      transform(path.resolve(src, node), path.resolve(dist, node))
    })

    return false
  } else if(!/\.java/.test(src)) {
    return false
  }

  let content = fs.readFileSync(src, 'utf-8')

  // 去掉所有换行符 连续空格
  content = content.replace(/\t\r\n/g, ' ')
  content = content.replace(/\s+/g, ' ')

  const superClassName = findSuperClassName(content)
  const className = findClassName(content)

  if(!className) {
    return console.log(chalk.red(`skip ${src}`))
  }

  const javaAttrs = findJavaAttributes(content)
  const tsAttrs = getTSAttributes(javaAttrs)

  let outputContent = `interface ${className} ${superClassName ? 'extends ' + superClassName : ''} {\r\n`

  tsAttrs.forEach(attr => {
    outputContent += `    ${attr.name}: ${attr.type}${attr.isArray? '[]' : ''};\r\n`
  })
  outputContent += '}'

  console.log(chalk.green(`${src} >>>> ${dist}`))
  fs.writeFileSync(dist.replace('.java', '.ts'), outputContent, 'utf-8')
  
}

function main() {
  const program = require('commander');
  program
  .option('-s, --src <string>', 'java directory', '.')
  .option('-d, --dist <string>', 'output directory', './dist')
  // .option('-r, --recursive')
  .parse(process.argv)
 
  const opts = program.opts()
  const src = path.resolve(opts.src)
  const dist = path.resolve(opts.dist)
  
  transform(path.resolve(src), path.resolve(dist))
}

main()
