package com.deepwise.ask.admin.entity.sickpostion;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Auther: lefeng.yi
 * @Date: 2018/12/5 15:43
 * @Description:
 */
public class SickPositionModel {

    @Data
    public static class ReqRelatedDiseaseParameter{
        private List<RelatedDiseaseItem> relatedDiseaseItems;
    }
    @Data
    public static class RelatedDiseaseItem{
        private Integer id;
        private Integer sickPositionId;
        private Integer featureId;
        private String name;
        private String diseaseNumber;
        private String diseaseName;
        private String description;
        private String imgJson;
        private Integer userId;
    }
    @Data
    public static class ReqSickPositionFeatureParameter{
        private Integer id;
        private Integer sickPositionId;
        private String name;
        private String description;
        private String imgJson;
        private Integer userId;
    }
    @Data
    public static class ReqSickPositionParameter {
        private Integer id;
        private String name;
        private String overview;
        private String imgJson;
        private Integer userId;
    }

    @Data
    public static class FeatureInfo {
        private List<FeatureItem> featureList;
        private int featureTotalPage;
        private int featurePage;
        private int featureStart;
        private int featureEnd;
    }

    @Data
    public static class  FeatureItem {
        private int id;
        private int positionId;
        private int userId;
        private String name;
        private String positionName;
        private String userName;
        private String imgJson;
        private String description;
        private Date creationTime;
        private Date updateTime;
    }

    public enum SaveStatus {
        SUCCESS(1, "成功"),
        EXIST_NAME(2, "存在相同名称"),
        ;
        private Integer status;
        private String msg;

        public Integer getStatus() {
            return status;
        }

        public String getMsg() {
            return msg;
        }

        SaveStatus(Integer status, String msg) {
            this.status = status;
            this.msg = msg;
        }
    }
}
