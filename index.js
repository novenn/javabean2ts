#!/usr/bin/env node

const fs = require('fs')
const path = require('path')
const chalk = require('chalk')
// const {rmdirRecursive} = require('./utils')
const tokenizer = require('./utils/tokenizer')

function filterTopCode(content) {
  const startIndex = content.indexOf('{') + 1
  const endIndex = content.lastIndexOf('}')
  content = content.slice(startIndex, endIndex)
  content = content.replace(/\t|\r|\n|(\r\n)/g, ' ').replace(/[^;]*\{(.*)\}/g, '')
  return content.replace(/\s+/g, ' ')
}


function transform(src, dist) {
  // 如果src 是一个目录
  // const stats = fs.statSync(src)
  // if (stats.isDirectory()) {

  //   // 如果存在的话 就清空目录
  //   if(fs.existsSync(dist)) {
  //     rmdirRecursive(dist)
  //   }

  //   const nodes = fs.readdirSync(src)
  //   nodes.forEach(node => {
  //     transform(path.resolve(src, node), path.resolve(dist, node))
  //   })

  //   return false
  // } else if(!/\.java/.test(src)) {
  //   return false
  // }

  let content = fs.readFileSync(src, 'utf-8')

  const tokens = tokenizer(content)
  // const lexicales = lexicaler(tokens)
  // const ast = parser(lexicales)
  // const target = complier(ast)
  console.log(tokens)
 
  // console.log(chalk.green(`${src} >>>> ${dist}`))
  // if(!fs.existsSync(path.dirname(dist))) {
  //   fs.mkdirSync(path.dirname(dist), {recursive: true})
  // }
  // fs.writeFileSync(dist.replace('.java', '.ts'), target, 'utf-8')
  
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
  let dist = path.resolve(opts.dist)

  const stats = fs.statSync(src)
  if(!stats.isDirectory()) {
    dist = path.resolve(dist, path.basename(src))
  }

  transform(path.resolve(src), path.resolve(dist))
}

main()
