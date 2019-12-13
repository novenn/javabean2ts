package com.deepwise.ask.admin.entity.disease;

import com.deepwise.apv.db.entity.ask.DiseaseIcd;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: lefeng.yi
 * @Date: 2018/11/5 10:47
 * @Description:
 */
@Data
public class DiseasePageModel {

    private DiseaseListInfo diseaseListInfo = new DiseaseListInfo();
    private List<DiseaseLevelItem> firstLevel;
    private List<DiseaseLevelItem> secondLevel;
    private List<DiseaseLevelItem> thirdLevel;
    private List<DiseaseLevelItem> positionLevel;
    private List<DiseaseLevelItem> cliSickPosition;
    private List<DiseaseLevelItem> strongTypeLevel;
    private List<DiseaseLevelItem> t1wiStrongLevel;
    private List<DiseaseLevelItem> dwiLevel;
    private List<DiseaseLevelItem> t2wiLevel;
    private List<DiseaseLevelItem> t1wiLevel;
    private List<DiseaseLevelItem> signsLevel;
    private List<BaseType> sickPositionList;

    private AntidiastoleModel antidiastole = new AntidiastoleModel();

    private String name; //疾病名称
    private String number; //疾病编号

    @Data
    public static class BaseType implements Serializable {
        private static final long serialVersionUID = 3093271240860255369L;
        private int id;
        private String name;
        private Date createTime;
        private Date updateTime;
    }

    @Data
    public static class AntidiastoleImageGroup implements Serializable {
        private static final long serialVersionUID = -5199493580415072672L;
        private List<AntidiastoleImage> imgList;
        private String content;//图片组综述
    }

    @Data
    public static class AntidiastoleImage implements Serializable {
        private char order;//图片顺序
        private String path;
        private String title;
    }

    @Data
    public static class DiseaseLevelItem implements Serializable {
        private static final long serialVersionUID = 1691245254964724025L;
        private int id;
        private int parentId;
        private int type;
        private String number;
        private String name;
    }

    @Data
    public static class DiseaseListInfo implements Serializable {

        private static final long serialVersionUID = 4774160725665709488L;
        private int pageIndex = 0;
        private int totalPage = 0;

        private int firstNumber;
        private int secondNumber;
        private int number;
        private String text;

        private List<DiseaseItemInfo> list;
    }

    @Data
    public static class DiseaseItemInfo implements Serializable {

        private static final long serialVersionUID = 7930699729335781783L;
        private int id;
        private String name;
        private String firstLevelName;
        private String secondLevelName;
        private String number;
        private Date createTime;
        private Date updateTime;
        private String userName;
        private Integer isRecall;
        private String sickPositionName;
        private int userId;
        private Integer status;
        private Integer isHidden;
        private Integer isAudited;
    }

    @Data
    public static class ClinicOrFeaturePosition implements Serializable {
        private static final long serialVersionUID = 8073801407983178424L;
        private int id;
        private String name;
    }

    @Data
    public static class ClinicFeatureModel implements Serializable {
        private static final long serialVersionUID = -3914560995761188222L;
        private int id;
        private int clinicId;
        private String content;
        private int type;
    }

    @Data
    public static class QuestionTypeModel implements Serializable {
        private static final long serialVersionUID = -387601606223805652L;
        private int type;
        private int sickPositionId;
        private String name;
        private List<Question> questions;
    }

    @Data
    public static class QuestionOptionModel implements Serializable {
        private static final long serialVersionUID = 3322849356197175474L;
        private int id;
        private int preconditionId;
        private String name;
        private boolean moreOption;
        private List<Option> options;
    }

    @Data
    public static class Question implements Serializable {
        private static final long serialVersionUID = 7667220677974903820L;
        private int id;
        private String name;
        private boolean moreOption;
        private List<Option> options;
    }

    @Data
    public static class Option implements Serializable {
        private static final long serialVersionUID = 8171058885821853126L;
        private int id;
        private int imageConditionId;
        private String name;
        private boolean selected = false;
        private float weight;
        private List<Question> questions;
    }

    @Data
    public static class AntidiastoleModel implements Serializable {
        private static final long serialVersionUID = -5052835809116256908L;
        private List<Antidiastole> list;//鉴别诊断列表
        private List<AntidiastoleImageBase> allList;//鉴别影像图全部列表
    }

    @Data
    public static class MapPathAndSickPathModel implements Serializable {
        private static final long serialVersionUID = 2012691418809862331L;
        private String title;
        private String path;
        private String type;
        private String filePath;
    }

    @Data
    public static class CaseItem implements Serializable {
        private static final long serialVersionUID = -5670772563787170725L;
        private String path;
        private String title;
    }

    @Data
    public static class CaseModel implements Serializable {
        private static final long serialVersionUID = -6415582300525418120L;
        private String number;
        private List<CaseItem> list;
    }

    @Data
    public static class AntidiastoleItem implements Serializable {
        private static final long serialVersionUID = -935105181408897157L;
        private Integer id;
        private String number;
        private String content;
        private String userId = "1";
        private int sickPositionId;
        private String sickPositionName;
        private String antDiseaseNumber;
        private String antDiseaseName;
        private String curList;
        private String antList;
    }

    @Data
    public static class SickPositionModel implements Serializable {
        private static final long serialVersionUID = -88885291198321436L;
        private List<SickPositionItem> list;
        private String name = "test";
        private String number;
    }

    @Data
    public static class DiagnosisPoint implements Serializable {
        private static final long serialVersionUID = -4845490788624336278L;
        private String number;
        private String points;
    }

    @Data
    public static class Mri implements Serializable {
        private static final long serialVersionUID = -1529029069519523593L;
        private String number;
        private Integer id;
        private String strongType_1;
        private String strongType_2;
        private String strongType_3;
        private String t1wi_1;
        private String t1wi_2;
        private String t1wi_3;
        private String t2wi_1;
        private String t2wi_2;
        private String t2wi_3;
        private String dwi_1;
        private String dwi_2;
        private String dwi_3;
        private String t1wistrong_1;
        private String t1wistrong_2;
        private String t1wistrong_3;
    }

    @Data
    public static class Clincial implements Serializable {
        private static final long serialVersionUID = 2507765599424423248L;
        private Integer id;
        private String number;
        private String symptom;
        private String treatment;
        private String seeAgeRange;
        private List<Float> seeAgeWeight;
        private String moreAgeRange;
        private List<Float> moreAgeWeight;
        private String feature;
        private Integer sex;
        private Integer history;
        private Integer hasGrowthPeriod;
    }

    @Data
    public static class ImageConditionModel implements Serializable {
        private static final long serialVersionUID = -6399047919659792642L;
        private float weight;
        private List<QuestionTypeModel> questionList;
        private List<AgeRange> ageRange;
        private String maleRate;
        private String femaleRate;
        private String sexWeight;
    }

    @Data
    public static class OptionWeights implements Serializable {
        private static final long serialVersionUID = -2879159482613244639L;
        private List<OptionWeight> diseaseList;
        private List<OptionWeight> optionList;
        private List<OptionWeight> groupList;
        private String diseaseNumbers;
    }

    @Data
    public static class OptionWeight implements Serializable {
        private static final long serialVersionUID = -9030821492484454559L;
        private int id;
        private float weight;
        private String diseaseNumber;
        private int sickPositionId;
        private int optionId;
        private Integer subDisaseaseId;
        private boolean selected = true;
    }

    @Data
    public static class ImageConditionOptionModel implements Serializable {
        private static final long serialVersionUID = 7389472503413123441L;
        private List<ImageConditionOptionsInfo> diseaseList;
    }

    @Data
    public static class ImageConditionOptionsInfo implements Serializable {
        private static final long serialVersionUID = 7340458519422805288L;
        private float weight;
        private Integer subDisaseaseId;
        private String subDisaseaseName;
        private int id;
        private String diseaseId;
        private String diseaseName;
        private List<OptionInfo> options;
    }

    @Data
    public static class OptionInfo implements Serializable {
        private static final long serialVersionUID = -1160010560021729194L;
        private int id;
        private int orderId;
        private int optionId;
        private String optionName;
        private float weight;
        private List<GroupInfo> groups;
    }

    @Data
    public static class GroupInfo implements Serializable {
        private static final long serialVersionUID = -6541227037514463845L;
        private Integer groupId;
        private String content;
        private float weight;
    }

    @Data
    public static class CopyFeatureModel implements Serializable {
        private static final long serialVersionUID = 8939957951817234241L;
        private String number;
        private Integer categoryId;
        private String categoryName;
        private int sickPositionId;
    }

    @Data
    public static class ImageFeatureModel implements Serializable {
        private static final long serialVersionUID = 6230901441680509527L;
        private String number;
        private Integer categoryId;
        private String categoryName;
        private float weight;
        private int sickPositionId;
        private List<ImageFeatureItem> list;
        private List<AgeRange> ageRange;
        private String maleRate;
        private String femaleRate;
        private String sexWeight;
    }

    @Data
    public static class ImageFeatureItem implements Serializable {
        private static final long serialVersionUID = 8776180381045076859L;
        private int imageConditionId;
        private int optionId;
        private int sickPositionId;
        private float weight;
        private String number;
        private Integer categoryId;
    }

    @Data
    public static class AgeRange implements Serializable {
        private static final long serialVersionUID = -2777001095967086253L;
        private String start;
        private String end;
        private String weight;
    }

    @Data
    public static class SummaryModel implements Serializable {
        private static final long serialVersionUID = 263182826611111559L;
        private String number;
        private String summary;
        private int showChance;
        private String alias;
        private String fullName;
        private String simpleName;
        private String icdCode;
        private int who1;
        private int who2;
        private int who3;
        private int who4;
        private int isRecall;
        private List<DiseaseIcd> list;
    }

    @Data
    public static class SickPositionItem implements Serializable {
        private static final long serialVersionUID = -8123367721393518924L;
        private int id;
        private String number;
        private String sickPositionName;
        private int parentId;
        private int sickPositionId;
        private String title;
        private int userId;
        private String imgPath;
    }

    @Data
    public static class ImgInfo implements Serializable {
        private static final long serialVersionUID = -2140513166620070102L;
        private String title;
        private String path;
    }

    @Data
    public static class InfoCaseModel implements Serializable {
        private static final long serialVersionUID = 6015150382930940560L;
        private Integer sickPositionId;
        private String sickPositionName;
        private Integer id;
        private Integer age;
        private Integer sex;
        private String diseaseNumber;
        private String main;
        private String history;
        private String now;
        private String mri;
        private String ct;
        private String t1wiSignal;
        private String t2wiSignal;
        private String t2FLAIRSignal;
        private String t1wiEnhanceShow;
        private String dwi;
        private String pwi;
        private String swi;
        private String mrs;
        private String bloodExamination;
        private String adc;
        private String inOperation;
        private String pathology;
        private String diagnosticIdeas;
        private List<MapPathAndSickPathModel> ctImages;
        private List<MapPathAndSickPathModel> t1wiImages;
        private List<MapPathAndSickPathModel> t2wiImages;
        private List<MapPathAndSickPathModel> t2FlairImages;
        private List<MapPathAndSickPathModel> t1wiEnhanceImages;
        private List<MapPathAndSickPathModel> dwiImages;
        private List<MapPathAndSickPathModel> adcImages;
        private List<MapPathAndSickPathModel> pwiImages;
        private List<MapPathAndSickPathModel> swiImages;
        private List<MapPathAndSickPathModel> mrsImages;
        private List<MapPathAndSickPathModel> bloodExaminationImages;
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
    public static class Antidiastole implements Serializable {
        private static final long serialVersionUID = 7716638352123521658L;
        private int id;
        private String antDiseaseNumber;
        private String antDiseaseName;
        private String content;
        private List<AntidiastoleImageBase> curList;
        private List<AntidiastoleImageBase> antList;
        private List<AntidiastoleImageBase> allAntList;
    }

    @Data
    public static class AntidiastoleImageBase implements Serializable {
        private static final long serialVersionUID = 1060412638430045548L;
        private int id;
        private String title;
        private List<AntidiastoleImage> imgInfoList;
        private String content;
    }

    @Data
    public static class AntidiastoleImageRequest implements Serializable {
        private static final long serialVersionUID = 5531792763109324470L;
        private Integer id;
        private String number;
        private String title;
        private String imgJson;
        private String content;
        private Integer sickPositionId;
        private String sickPositionName;
        private String userId;
    }
}
