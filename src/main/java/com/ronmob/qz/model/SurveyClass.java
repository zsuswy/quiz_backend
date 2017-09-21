package com.ronmob.qz.model;

public class SurveyClass {
    private Integer id;

    private String className;

    private Integer parentClassId;

    private Byte enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getParentClassId() {
        return parentClassId;
    }

    public void setParentClassId(Integer parentClassId) {
        this.parentClassId = parentClassId;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }
}