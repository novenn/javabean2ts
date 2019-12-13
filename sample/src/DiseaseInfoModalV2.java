package com.deepwise.ask.admin.entity;

import com.deepwise.apv.db.entity.ask.DiseaseInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiseaseInfoModalV2 {
    private List<DiseaseInfo> diseaseInfoList = new ArrayList<>();
    private Integer pageIndex;
    private Integer totalPage;
    private Integer total;
}
