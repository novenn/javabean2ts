package com.deepwise.ask.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/9/26 13:11
 * @Description:
 */
@Data
public class JsonModelCase implements Serializable {

    private static final long serialVersionUID = -1101889591366642703L;
    private String gender; //性别
    private int age;
    private String chiefComplaint; //主诉
    private String medicalHistory; //既往病史
    private String nowBody;         //现病史及查体
    private String image;           //影像检查图片
    private String imagetudies;     //影像检查描述
    private String afterPathology;  //术后病理
}
