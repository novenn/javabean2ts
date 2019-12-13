package com.deepwise.ask.admin.entity;

import java.util.HashMap;

public class ResponseModel {

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final Integer ZERO = 0;
    public static final Integer NEGATIVE_ONE = -1;
    private static HashMap<String, Object> model = null;
    private ResponseModel() {
    }

    public static HashMap<String, Object> getModel(String msg, String status, Object data) {
        model = new HashMap<>();
        model.put("msg", msg);
        model.put("status", status);
        model.put("data", data);
        return model;
    }

    public static HashMap<String, Object> getModel(String msg, Integer status, Object data) {
        model = new HashMap<>();
        model.put("msg", msg);
        model.put("status", status);
        model.put("data", data);
        return model;
    }

    public static HashMap<String, Object> getModel(ResultEnum resultEnum, Object data) {
        model = new HashMap<>();
        model.put("msg", resultEnum.getMsg());
        model.put("status", resultEnum.getStatus());
        model.put("data", data);
        return model;
    }

}
