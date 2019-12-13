package com.deepwise.ask.admin.entity.casetest;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: X.D.Yang
 * @Date 2019/3/6 15:24
 * @Description
 */
@Data
public class QueryParameter implements Serializable {
    private static final long serialVersionUID = 2210769383007560121L;
    private Integer pageIndex = 1;
    private Integer sickPositionId;    //发病位置
    private Integer sex;                //性别
    private Integer age;
    private List<SubtypesRecallOptionIdsReq> optionIdsReqList;
    private Map<Integer, List<SubtypesRecallOptionIdsReq>> map = new HashMap<>();
    private String queName;
    private String allQueName;
    private String clcValue;
    private List<Integer> max;
    private Ps ps;

    @Data
    public static class SubtypesRecallOptionIdsReq implements Serializable {
        private static final long serialVersionUID = -6093617867502449069L;
        private Integer questionId;         //问题
        private List<Integer> optionIds;    //选项
    }

    @Data
    public static class Ps implements Serializable {
        private static final long serialVersionUID = 5767228983211726995L;
        private Integer sickPositionId;          //发病位置编号
        private Integer age;                      //年龄
        private Integer gender;                   //性别
        private String sickPositionOptionIds;   //发病位置问题选项，支持多个用英文逗号隔开，例如：{optionId1},{option2}...
    }
}
