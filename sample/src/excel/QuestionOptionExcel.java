package com.deepwise.ask.admin.entity.excel;

import com.deepwise.apv.annotation.ExcelAnnotation;
import lombok.Data;

/**
 * @Auther: yanbing
 * @Date: 2019/4/19
 * @Description:
 */
@Data
public class QuestionOptionExcel {
    @ExcelAnnotation(name = "问题id")
    private Integer id;
    @ExcelAnnotation(name = "问题名称")
    private String questionName;
    @ExcelAnnotation(name = "特殊问题示例")
    private String name;
    @ExcelAnnotation(name = "发病位置")
    private String sickPositionName;
    @ExcelAnnotation(name = "问题类型")
    private String questionType;
}
