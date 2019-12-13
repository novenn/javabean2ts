package com.deepwise.ask.admin.entity;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/12/20 10:50
 * @Description:
 */
public enum ItemType {
    QUESTION(1, "问题"),
    GENDER(2, "性别"),
    AGE(3, "年龄");

    private int code;
    private String desc;

    ItemType(int code, String desc) {
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
        return "ItemType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
