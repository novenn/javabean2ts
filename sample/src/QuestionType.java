package com.deepwise.ask.admin.entity;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/12/20 10:50
 * @Description:
 */
public enum QuestionType {
    POSITIONFEATURE(1, "发病位置"),
    IMAGEFEATURE(2, "影像特征"),
    LESIONSNATURE(3, "病变性质"),
    CLINICFEATURE(4, "临床特点"),
    CT(5, "CT影像"),
    MRI(6, "MRI序列"),
    REVIEW(7, "实验室检查");

    private int code;
    private String desc;

    QuestionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "QuestionType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
