const fs = require('fs')
const path = require('path')

function findClassName(content) {
  return content.match(/class\s+(.*?)\s+/, content)[1]
}

function findJavaAttributes(content) {
  // 删除掉所有的方法
  const attrs = []
  const attrReg = /(public|private)\s+([a-zA-Z]+)\s+([a-zA-z0-9_,\s]+);/g
  content.match(attrReg).forEach(item => {
    const p = attrReg.exec(content).slice(2,4)
    const type = p[0]
    const names = p[1].replace(/\s+/, '').split(',')
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
      type: mapper[item.type] || item.type,
      name: item.name
    })
  })

  return attrs
}

function transform(src, dist) {
  let content = fs.readFileSync(src, 'utf-8')

  // 去掉所有换行符 连续空格
  content = content.replace(/\t\r\n/g, ' ')
  content = content.replace(/\s+/g, ' ')

  const className = findClassName(content)
  const javaAttrs = findJavaAttributes(content)
  const tsAttrs = getTSAttributes(javaAttrs)

 
  let outputContent = `interface ${className} {\r\n`

  tsAttrs.forEach(attr => {
    outputContent += `    ${attr.name}: ${attr.type};\r\n`
  })

  outputContent += '}'

  console.log(outputContent)
  fs.writeFileSync(dist, outputContent, 'utf-8')
  
}

transform('./src/test.java', './dist/test.ts')