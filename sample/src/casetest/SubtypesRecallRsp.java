package com.deepwise.ask.admin.entity.casetest;

import com.deepwise.apv.entity.elastic.ClassificationSubtypesES.AntDiseaseInfoSickPosition;
import com.deepwise.apv.entity.elastic.InfoES.ImagePath;
import com.deepwise.apv.entity.elastic.SickPositionWeightES.AgeRange;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: lefeng.yi
 * @Date: 2019/4/1 20:44
 * @Description:
 */
@Data
public class SubtypesRecallRsp implements Serializable {

    private static final long serialVersionUID = 7133901883237346743L;

    @Data
    public static class SubtypesRecallItems implements Serializable {
        private static final long serialVersionUID = -2678367244636518140L;
        private Integer totalPage;
        private Integer total;
        private Integer currentPage;
        private Integer pageSize;
        private List<SubtypesRecallItem> list;
    }

    @Data
    public static class SubtypesRecallItem implements Serializable {
        private static final long serialVersionUID = -4638129185065503755L;
        private Integer subtypesId;     //分类亚型编号
        private String subtypesName;   //亚型名称
        private String diseaseNumber;        //疾病编号
        private String diseaseName;         //疾病名称
        private String alias;               //疾病别称
        private List<AntDiseaseInfoSickPosition> antDiseaseInfoSickPositions; //分区鉴别疾病列表
        private float socre;                     //评分
        private List<Integer> matchOptionIds;   //匹配项
        private AgeRange matchAgeRange;         //匹配年龄
        private List<ImagePath> imgs;            //示意图
    }
}
