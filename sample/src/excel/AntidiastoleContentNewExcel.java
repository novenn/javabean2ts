package com.deepwise.ask.admin.entity.excel;

import com.deepwise.apv.annotation.ExcelAnnotation;
import lombok.Data;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/8/10 10:50
 * @Description:
 */
@Data
public class AntidiastoleContentNewExcel {

    @ExcelAnnotation(name = "一级疾病名称")
    private String firstName;

    @ExcelAnnotation(name = "二级疾病名称")
    private String secondName;

    @ExcelAnnotation(name = "三级疾病名称")
    private String thirdName;

    @ExcelAnnotation(name = "鉴别诊断无超链接疾病名称")
    private String diseaseName;

    @ExcelAnnotation(name = "无链接疾病content")
    private String content;
}
