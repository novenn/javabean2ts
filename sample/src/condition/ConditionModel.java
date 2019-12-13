package com.deepwise.ask.admin.entity.condition;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther:yanbing
 * @Date:2019/1/8
 * @Description:
 */
@Data
public class ConditionModel implements Serializable {
    private static final long serialVersionUID = 1133838590058653740L;
    private SaveQuestionReq param;

    public enum SaveStatus {
        SUCCESS(1, "成功"),
        EXIST_NAME(2, "存在相同名称"),
        EXIST_CONDITION_NAME(3, "存在相同条件名称");
        private Integer status;
        private String msg;

        SaveStatus(Integer status, String msg) {
            this.status = status;
            this.msg = msg;
        }

        public Integer getStatus() {
            return status;
        }

        public String getMsg() {
            return msg;
        }
    }

    @Data
    public static class ConditionRes implements Serializable {
        private static final long serialVersionUID = -5952466314360903669L;
        private List<Base> sickPositionList;
        private List<Condition> conditionList;
        private List<Base> questionTypeList;
    }

    @Data
    public static class Condition implements Serializable {
        private static final long serialVersionUID = -8594646881200308795L;
        private int id;
        private int sickPositionId;
        private String sickPositionName;
        private int order;
        private int conditionType;//选项类型，来自表question_type
        private String conditionName;//类型名称，来自表question_type
        private Date creationTime;
        private Date updateTime;
        private String user;
        private Integer isAudited;
    }

    @Data
    public static class Base implements Serializable {
        private static final long serialVersionUID = 4426525957911375441L;
        private int id;
        private String name;
    }

    @Data
    public static class QuestionRes implements Serializable {
        private static final long serialVersionUID = -7489887461473666509L;
        private List<Question> questionList;
    }

    @Data
    public static class Question implements Serializable {
        private static final long serialVersionUID = -2918970796113768958L;
        private int id;
        private String name;
        private String alias; //问题简称
        private int predictionId;
        private String predictionName;//前置问题
        private List<PredictionItem> predictionItems;//前置选项
        private boolean moreOption;
        private boolean fullMatch;
        private List<Option> optionList;
        private Boolean isHidden;
    }

    @Data
    public static class PredictionItem implements Serializable {
        private static final long serialVersionUID = 8628938045858622158L;
        private int id;
        private String name;
        private boolean flag;
    }

    @Data
    public static class Option implements Serializable {
        private static final long serialVersionUID = 8628938045858622158L;
        private int id;
        private String name;
        private int hintId;
        private String hintName;
    }

    @Data
    public static class QueryQuestion implements Serializable {
        private static final long serialVersionUID = -3103290070903531465L;
        private List<PreQuestion> questionList;
    }

    @Data
    public static class PreQuestion implements Serializable {
        private static final long serialVersionUID = 1257023931761344432L;
        private int id;
        private String name;
        private List<Base> optionList;
    }

    @Data
    public static class SaveQuestionReq implements Serializable {
        private static final long serialVersionUID = -8509925210507091925L;
        private int id;
        private int sickPositionId;
        private byte conditionType;
        private int order;
        private List<SaveQuestion> questionList;
    }

    @Data
    public static class SaveQuestion implements Serializable {
        private static final long serialVersionUID = 678780410366846765L;
        private int queId;
        private String queName;
        private String alias;
        private int predictionId;
        private String predictItems;
        private Boolean fullMatch;
        private Boolean moreOption;
        private List<OptionBase> optionList;
        private Boolean isHidden;
    }

    @Data
    public static class OptionBase implements Serializable {
        private static final long serialVersionUID = -8133742445332017362L;
        private int id;
        private String name;
        private int hintId;
    }

    @Data
    public static class QueryHint implements Serializable {
        private static final long serialVersionUID = 5525273115385586313L;
        private List<Base> hintList;
    }

    @Data
    public static class QueryQuestionRes implements Serializable {
        private static final long serialVersionUID = -790025634683819551L;
        private int sickPositionId;
        private String sickPositionName;
        private String conditionName;
        private int conditionType;
        private int order;
        private Question question;
    }

    @Data
    public static class CurrentQuestionReq implements Serializable {
        private static final long serialVersionUID = -2347752825907204068L;
        private int sickPositionId;
        private byte conditionType;
        private int order;
        private int id;
        private SaveQuestion question;
    }

    @Data
    public static class ErrorHint implements Serializable {
        private static final long serialVersionUID = 550218097126041876L;
        private int id;
        private String errMsg;

        public ErrorHint(Integer id, String msg) {
            this.id = id;
            this.errMsg = msg;
        }
    }

    @Data
    public static class Hint implements Serializable {
        private static final long serialVersionUID = 550218097126041876L;
        private HintDetail hintDetail;
        private String errMsg;

        public Hint(HintDetail hintDetail, String msg) {
            this.hintDetail = hintDetail;
            this.errMsg = msg;
        }
    }

    @Data
    public static class HintDetail implements Serializable {
        private static final long serialVersionUID = -6052119183652060280L;
        private Integer id;
        private String sickPositionName;
        private String questionTypeName;
    }
}
