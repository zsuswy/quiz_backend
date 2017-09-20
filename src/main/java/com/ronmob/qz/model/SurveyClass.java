package com.ronmob.qz.model;

public class SurveyClass {
    private Integer id;
    private Integer parent_class_id;
    private String class_name;
    private Integer enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_class_id() {
        return parent_class_id;
    }

    public void setParent_class_id(Integer parent_class_id) {
        this.parent_class_id = parent_class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
