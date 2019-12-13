package com.deepwise.ask.admin.entity;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/12/20 10:50
 * @Description:
 */
public enum TimeType {
    CREATETIME(0, "创建时间"),
    UPDATETIME(1, "更新时间");

    private int code;
    private String desc;

    TimeType(int code, String desc) {
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
        return "TimeType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
