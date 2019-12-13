package com.deepwise.ask.admin.entity;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/12/20 10:50
 * @Description:
 */
public enum RecalledType {
    ALL(3, "全部疾病"),
    RECALLEDED(2, "召回疾病"),
    NORECALLED(1, "未召回疾病");

    private int code;
    private String desc;

    RecalledType(int code, String desc) {
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
        return "RecalledType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
