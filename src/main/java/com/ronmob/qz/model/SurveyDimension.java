package com.ronmob.qz.model;

public class SurveyDimension {
    private Integer id;

    private Integer parentId;

    private Integer surveyId;

    private Integer seq;

    private String dimensionName;

    private Byte autoCalculateType;

    private Integer proxySubDimensionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName == null ? null : dimensionName.trim();
    }

    public Byte getAutoCalculateType() {
        return autoCalculateType;
    }

    public void setAutoCalculateType(Byte autoCalculateType) {
        this.autoCalculateType = autoCalculateType;
    }

    public Integer getProxySubDimensionId() {
        return proxySubDimensionId;
    }

    public void setProxySubDimensionId(Integer proxySubDimensionId) {
        this.proxySubDimensionId = proxySubDimensionId;
    }
}