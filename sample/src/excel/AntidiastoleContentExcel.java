package com.deepwise.ask.admin.entity.excel;

import com.deepwise.apv.annotation.ExcelAnnotation;
import lombok.Data;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/8/10 10:50
 * @Description:
 */
@Data
public class AntidiastoleContentExcel {

    @ExcelAnnotation(name = "疾病名称")
    private String diseaseName;

    @ExcelAnnotation(name = "鉴别诊断疾病编号")
    private Integer number;

    @ExcelAnnotation(name = "鉴别诊断疾病标题")
    private String title;

    @ExcelAnnotation(name = "鉴别诊断疾病内容")
    private String content;
}
