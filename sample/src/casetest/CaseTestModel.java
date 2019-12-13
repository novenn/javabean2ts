package com.deepwise.ask.admin.entity.casetest;

import com.deepwise.apv.db.entity.ask.CaseTest;
import com.deepwise.ask.admin.entity.disease.DiseasePageModel.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: X.D.Yang
 * @Date 2019/2/20 14:12
 * @Description
 */
@Data
public class CaseTestModel {

    @Data
    public static class CaseTestQueryReq implements Serializable {
        private static final long serialVersionUID = -7192745235355566745L;
        private Integer pageIndex = 1;
        private QueryParameter ps;
    }

    @Data
    public static class CaseTestAddReq implements Serializable {
        private static final long serialVersionUID = -997035910612480026L;
        private String diseaseName;
        private String diseaseNumber;
        private String name;
        private String sickPositionName;
        private String origin;
        private String main;
        private Integer sex;
        private Integer age;
        private Integer caseTestId;
        private Integer sickPositionId;
    }

    @Data
    public static class CaseConditionReq implements Serializable {
        private static final long serialVersionUID = -6472976417985363453L;
        private int caseTestId;
        private List<CaseOptionItem> list;
    }

    @Data
    public static class CaseOptionItem implements Serializable {
        private static final long serialVersionUID = 6443082251717321753L;
        private int id;
        private int optionId;
        private int caseTestId;
    }

    @Data
    public static class QueryParameter implements Serializable {
        private static final long serialVersionUID = -7117089379363750028L;
        private String key;
        private String origin;
        private Integer sickPositionId;
        private String userId;
        private String startTime;
        private String endTime;
        private String timeMode;
    }

    @Data
    public static class JsonCaseQuery implements Serializable {
        private static final long serialVersionUID = -2517272084498875757L;
        private Integer totalPage;
        private Integer total;
        private Integer currentPage;
        private Integer pageSize;
        private List<JsonCaseTest> list;
    }

    @Data
    public static class JsonCaseTest implements Serializable {
        private static final long serialVersionUID = 1008694022485565057L;
        private Integer id;
        private String diseaseNumber;
        private String diseaseName;
        private String name;
        private Integer sickPositionId;
        private String sickPositionName;
        private Integer sex;
        private Integer age;
        private String main;
        private String origin;
        private Integer userId;
        private String username;
        private Date creationTime;
        private Date updateTime;
    }

    @Data
    public static class JsonCaseOptions implements Serializable {
        private static final long serialVersionUID = 5648256078810978254L;
        private String diseaseName;
        private String diseaseNumber;
        private String name;
        private String sickPositionName;
        private String origin;
        private String main;
        private Integer sex;
        private Integer age;
        private Integer caseTestId;
        private Integer sickPositionId;
        private List<QuestionTypeModel> questionList;
    }

}
