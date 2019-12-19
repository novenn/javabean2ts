#!/usr/bin/env node

const fs = require('fs')
const path = require('path')
const chalk = require('chalk')
const {rmdirRecursive} = require('./utils')

function deleteInnerBlock(content) {
  var reg = /((public|private)?\s+([a-zA-Z0-9_]+\s*)*(\((.*?)\))\s+{)/g
  var arr = content.match(reg)
  console.log(arr)
  const len = arr.len
  for(let i=len - 1; i >= 0; i--) {
    content = content.
  }
  return content
}

function findSuperClassName(content) {
  const arr = content.match(/implements\s+(.*?)\s+/, content)
  return arr && arr[1]
}

function findClassName(content) {
  const arr = content.match(/class\s+(.*?)\s+/, content)
  return arr && arr[1]
}

function findEnumName(content) {
  const arr = content.match(/enum\s+(.*?)\s+/, content)
  return arr && arr[1]
}

function findEnumItems(content) {
  // 删除所有方法文本
  // content = content.replace(/(private|public)\s*([a-zA-Z0-9_])\s*(*)/g, '')
  content = deleteInnerBlock(content)
  const reg = /([a-zA-Z0-9_]+)(\(.*?\))?(,|;)/
  const arr = content.match(new RegExp(reg, 'g'))
  arr && arr.forEach(item => {
    const p = reg.exec(item).slice(1)
    console.log(p)
  })
}

function findJavaAttributes(content) {
  // private Map<Integer, List<SubtypesRecallOptionIdsReq>> map = new HashMap<>();
  // private int code;
  // private string code;
  // private List<Integer> max;
  // private 
  const attrs = []
  const attrReg =  /(\/\*.*?\*\/)(?:public|private)\s+([a-zA-Z]+)(?:\s*(\[\])|(?:<(.*?)>))?\s+([a-zA-z0-9_,\s]+)(;|=)/
  const arr = content.match(new RegExp(attrReg, 'g'))
  arr && arr.forEach(item => {
    const p = attrReg.exec(item).slice(1)
    const isList = p[2] && p[2].indexOf(',') === -1
    const isMap = p[2] && p[2].indexOf(',') !== -1
    const isArray = !!p[1]
    const names = p[3].replace(/\s+/, '').split(',')
    let type = p[0]

    if(isMap) {
      type = 'Object'
    } else if(isList) {
      type = p[2] + '[]'
    } else if(isArray) {
      type = p[0] + '[]'
    }


    names.forEach(name => {
      attrs.push({
        type,
        name
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
      type: (mapper[item.type] || item.type),
      name: item.name
    })
  })

  return attrs
}

function isBean(content) {

}

function isEnum(content) {
  return /public\s+enum\s+(.*?){/.test(content)
}

function transformBean(content) {
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
     outputContent += `    ${attr.name}: ${attr.type};\r\n`
   })
   outputContent += '}'

   return outputContent
}

function transformEnum(content) {
  const enumName = findEnumName(content)
  const items = findEnumItems(content)

  return 'ss'
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
  let outputContent = ''

  // 判断是不是一个标准bean对象
  if(isBean(content)) {
    outputContent = transformBean(content)
  } else if(isEnum(content)) {
    outputContent = transformEnum(content)
  }

 
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
