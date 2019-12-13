package com.deepwise.ask.admin.entity.feature;

import com.deepwise.apv.db.entity.ask.QuestionOption;
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
public class SpecialFeatureModel {

    @Data
    public static class SpecialFeatureQueryReq implements Serializable {
        private static final long serialVersionUID = -2058421642493750676L;
        private String diseaseNumber;
        private Integer sickPositionId;
    }

    @Data
    public static class FeatureCategoryJson implements Serializable {
        private static final long serialVersionUID = 245996680056222163L;
        private Integer id;
        private Integer sickPositionId;
        private String diseaseNumber;
        private String name;
        private Integer userId;
        private String username;
        private Date creationTime;
        private Date updateTime;
    }

    @Data
    public static class SpecialFeatureAddReq implements Serializable {
        private static final long serialVersionUID = -245042806752008303L;
        private String diseaseNumber;
        private String name;
        private Integer id;
        private Integer sickPositionId;
    }

    @Data
    public static class QuestionOptionReq implements Serializable {
        private static final long serialVersionUID = 3851121652778767461L;
        private String keyword;
        private String diseaseNumber;
        private Integer sickPositionId;
    }

    @Data
    public static class QuestionOptionRsp implements Serializable {
        private static final long serialVersionUID = 4879193801649940940L;
        private String questionName;
        private int questionId;
        private Integer type;
        private boolean moreOption;
        private List<QuestionOption> options;
    }

    @Data
    public static class GroupRsp implements Serializable {
        private static final long serialVersionUID = 7285147494768771738L;
        private Integer categoryId;
        private List<Group> groups;
    }

    @Data
    public static class Group implements Serializable {
        private static final long serialVersionUID = 3601479628886095784L;
        private Integer groupId;
        private List<QuestionItem> questionItems;
        private float weight;
    }

    @Data
    public static class QuestionItem implements Serializable {
        private static final long serialVersionUID = -7708506629322439490L;
        private Integer type;
        private int questionId;
        private String questionName;
        private boolean moreOption;
        private List<OptionItem> optionItems;
    }

    @Data
    public static class OptionItem implements Serializable {
        private static final long serialVersionUID = -2381640181002457198L;
        private Integer itemId;
        private int optionId;
        private String optionName;
        private int otherId;
        private boolean selected = false;
    }

}
