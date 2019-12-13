package com.deepwise.ask.admin.entity.excel;

import com.deepwise.apv.annotation.ExcelAnnotation;
import lombok.Data;

/**
 * @Auther: yanbing
 * @Date: 2019/1/24
 * @Description:
 */
@Data
public class SignsHintExcel {
    @ExcelAnnotation(name = "名称")
    private String name;

    @ExcelAnnotation(name = "描述")
    private String description;

    @ExcelAnnotation(name = "别称")
    private String alias;

}
