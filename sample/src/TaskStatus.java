package com.deepwise.ask.admin.entity;

/**
 * @Auther: X.D.Yang
 * @Date 2018/9/19 11:05
 * @Description 任务状态枚举Code
 */
public enum TaskStatus {
    EXECUTORY_CONTRACT(0, "待执行"),
    EXECUTORY_RUNNING(1, "执行中"),
    EXECUTORY_SUCCESS(2, "执行成功"),
    EXECUTORY_FAIELD(3, "执行失败");

    private int code;
    private String msg;

    TaskStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static TaskStatus valueOf(int code) {
        for (TaskStatus taskStatus : values()) {
            if (taskStatus.getCode() == code) {
                return taskStatus;
            }
        }
        throw new RuntimeException(String.format("TaskStatus is not value %d", code));
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
