package com.deepwise.ask.admin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: X.D.Yang
 * @Date 2018/10/13 10:43
 * @Description
 */
@Data
public class EvolutionProcess implements Serializable {
    private static final long serialVersionUID = 4095796044967222231L;
    private FirstDisease firstDisease;
    private ShowJson showJson;
    private List<String> subDiseaseId;

    @Data
    public static class FirstDisease implements Serializable {
        private static final long serialVersionUID = -9196833684930299081L;
        private String id;
        private String name;
    }

    @Data
    public static class ShowJson implements Serializable {
        private static final long serialVersionUID = -5625947159181269390L;
        private List<String> column;
        private List<List<String>> row;
    }
}
