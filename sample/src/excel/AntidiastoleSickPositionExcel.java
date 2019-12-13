package com.deepwise.ask.admin.entity.excel;

import com.deepwise.apv.annotation.ExcelAnnotation;
import lombok.Data;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/8/10 10:50
 * @Description:
 */
@Data
public class AntidiastoleSickPositionExcel {

    @ExcelAnnotation(name = "疾病名称")
    private String name;

    @ExcelAnnotation(name = "鉴别疾病名称")
    private String antName;

    @ExcelAnnotation(name = "鉴别内容")
    private String content;
}
