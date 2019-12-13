package com.deepwise.ask.admin.entity;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/12/20 10:50
 * @Description:
 */
public enum AgeType {
    SEEAGE(0, "可见发病年龄"),
    MOREAGE(1, "多见发病年龄");

    private int code;
    private String desc;

    AgeType(int code, String desc) {
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
        return "AgeType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
