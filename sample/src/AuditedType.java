package com.deepwise.ask.admin.entity;

/**
 * @Auther: X.D.Yang
 * @Date: 2018/12/20 10:50
 * @Description:
 */
public enum AuditedType {
    NOAUDITED(0, "未审核"),
    AUDITED(1, "已审核");

    private int code;
    private String desc;

    AuditedType(int code, String desc) {
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
        return "AuditedType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
