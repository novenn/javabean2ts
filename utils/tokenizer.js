/**
 * 关键字分类：
 *  类型声明：boolean、byte、char、 double、float、int、long、new、short、void、instanceof
 *  语句控制：break、case、 catch、 continue、 default 、do、 else、 for、 if、return、switch、try、 while、 finally、 throw、this、 super
 *  用于修饰：abstract、final、native、private、 protected、public、static、synchronized、transient、 volatile
 *  类包接口：class、 extends、 implements、interface、 package、import、throws
 *  内置常量：true、false、null
 * 标识符：/$[a-zA-Z_$][0-9A-Za-z_$]*$/
 * 运算符：
 *  算数运算符：+（正号）、-（负号）、+、-、*、/、%、++，--
 *  关系运算符：==、!=、>、<、>=、<=
 *  赋值运算符：=、+=、-+、*=、/=、%=、&=、|=、>>=、<<=、^=
 *  逻辑运算符：&、|、!、^、&&、||
 *  位运算符：&、|、^、>>,<<,>>>(无符号左移)、~
 *  条件运算符：?:
 * 界 符：.、[、]、(、)、{、}
 * instanceOf运算符：
 *  instanceOf
 */
 
function tokenizer(code) {
    let index = 0
    let cache = ''
    let tokens = []
    while (true) {
        let ch = code[index]
        // 过滤调注释
        if ( ch === '/' ) {
            let start = index
            ch = code[++index]
            const singleMode = ch === '/'

            while (ch) {
                ch = code[++index]
                if (singleMode) {
                    if('\r' === ch) {
                        if(code.substr(index, 2) === '\r\n') {
                            index += 1
                            break
                        } else if(code.substr(index, 1) === '\r') {
                            break
                        }
                    }
                } else {
                    if('*' === ch && code[index + 1] === '/') {
                        index += 1
                        break
                    }
                }
            }

            tokens.push({
                type: 'comment',
                value: code.slice(start, index + 1)
            })

            ch = code[++index]
            cache = ''
            
        }

        // 第一个数数数字的换 进入数匹配模式
        // 132.44E-4
        else if (/\d/.test(ch)) {
            while (true) {
                if(/[\d\.Ee]/.test(ch)) {
                    cache += ch
                } else if(ch === '+' || ch === '-') {
                    if (/[eE]/.test(code[index - 1])) {
                        cache += ch
                    } else {
                        break;
                    }
                } else {
                    break
                }

                ch = code[++index]
            }

            tokens.push({
                type: 'number',
                value: cache
            })

            cache = ''

        } 
        // 进入字符串匹配模式
        else if(ch === '"' || ch === '\'') {
            const start = ch
            ch = code[++index]
            while (ch) {
                
                if(ch === start && code[index - 1] !== '\\') {
                    ch = code[++index]
                    break
                } else {
                    cache += ch
                    ch = code[++index]
                }
            }

            tokens.push({
                type: 'string',
                value: cache
            })

            cache = ''
        }
        // 第一个字符是字母、下划线、$进入标识符/关键字匹配模式
        else if(/[a-zA-Z_$]/.test(ch)) {
            
            while (true) {
                if(/[a-zA-Z0-9_$]/.test(ch)) {
                    cache += ch
                    ch = code[++index]
                } else {
                    break
                }
            }

            tokens.push({
                type: 'word',
                value: cache
            })
            cache = ''
        } else if(ch === '.') {
            tokens.push({
                type: 'dot',
                value: ch
            })
            ch = code[++index]
        } else if(ch === '{' || ch === '}') {
            tokens.push({
                type: 'brace',
                value: ch
            })
            ch = code[++index]
        } else if(ch === '[' || ch === ']') {
            tokens.push({
                type: 'bracket',
                value: ch
            })
            ch = code[++index]
        }  
        // + += ++
        else if(ch === '+') {
            cache = ch
            ch = code[++index]
            if(ch === '+' || ch === '=') {
                cache += ch
                ch = code[++index]
            }
            tokens.push({
                type: 'operator', 
                value: cache
            })
            cache = ''
        } else {
            ch = code[++index]
        }

        if(!ch) {
            break
        }
    }

    return tokens
}

module.exports = tokenizer