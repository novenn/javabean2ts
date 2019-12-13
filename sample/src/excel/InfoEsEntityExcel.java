package com.deepwise.ask.admin.entity.excel;

import com.deepwise.apv.annotation.ExcelAnnotation;
import lombok.Data;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/8/10 10:50
 * @Description:
 */
@Data
public class InfoEsEntityExcel {

    @ExcelAnnotation(name = "疾病编号")
    private Integer number;

    @ExcelAnnotation(name = "疾病名称")
    private String diseaseName;

    @ExcelAnnotation(name = "T1WI")
    private String t1wi;

    @ExcelAnnotation(name = "T2WI")
    private String t2wi;

    @ExcelAnnotation(name = "发病位置")
    private String sickPosition;

    @ExcelAnnotation(name = "单发多发")
    private String occur;

    @ExcelAnnotation(name = "好发年龄")
    private String age;

    @ExcelAnnotation(name = "好发性别")
    private String sex;

    @ExcelAnnotation(name = "DWI")
    private String dwi;

    @ExcelAnnotation(name = "增强")
    private String strong;

    @ExcelAnnotation(name = "PWI")
    private String pwi;

    @ExcelAnnotation(name = "肿瘤边缘")
    private String edge;

    @ExcelAnnotation(name = "形态")
    private String shape;

    @ExcelAnnotation(name = "囊变/坏死")
    private String cysticNecrosis;

    @ExcelAnnotation(name = "钙化")
    private String calcify;

    @ExcelAnnotation(name = "占位效应")
    private String occupy;

    @ExcelAnnotation(name = "特殊征象")
    private String special;

    @ExcelAnnotation(name = "诊断要点")
    private String point;

    @ExcelAnnotation(name = "鉴别诊断")
    private String content;
}
