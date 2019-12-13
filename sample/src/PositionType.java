package com.deepwise.ask.admin.entity;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/12/20 10:50
 * @Description:
 */
public enum PositionType {
    SADDLE(1, "鞍区"),
    PINEALREGION(2, "松果体区"),
    CEREBELLOPONTINE(3, "桥小脑角"),
    CEREBELLUMQUADRIVENTRICLE(4, "小脑和四脑室"),
    TRICORN(5, "侧脑室"),
    THALAMUSBASAL(6, "丘脑和基底节区"),
    CEREBRAL(7, "大脑半球");

    private int code;
    private String desc;

    PositionType(int code, String desc) {
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
        return "PositionType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
