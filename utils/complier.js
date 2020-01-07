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

function compiler(ast) {

}

export default compiler

export {
    compiler
}