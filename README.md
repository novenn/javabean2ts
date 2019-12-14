# javabean2ts

utility for transforming java beans to typescript interface

## features
- support all java base types
- support customer class
- support array
- suuport recursive processing

## using

install as a global cli
>npm install javabean2ts -g

transform code
> javabean2ts -s ./src -d ./dist


## options
|-|option|long option| default | desc|
|-|-|-|-|-|
|1|-s|-src|./|input java code dir|
|2|-d|-dist|./dist|java code dir|
