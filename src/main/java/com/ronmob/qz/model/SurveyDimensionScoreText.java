package com.ronmob.qz.model;

public class SurveyDimensionScoreText {
    private Integer id;

    private Integer dimensionId;

    private Integer scoreMax;

    private Integer scoreMin;

    private String resultTitle;

    private String resultComment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(Integer dimensionId) {
        this.dimensionId = dimensionId;
    }

    public Integer getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(Integer scoreMax) {
        this.scoreMax = scoreMax;
    }

    public Integer getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }

    public String getResultTitle() {
        return resultTitle;
    }

    public void setResultTitle(String resultTitle) {
        this.resultTitle = resultTitle == null ? null : resultTitle.trim();
    }

    public String getResultComment() {
        return resultComment;
    }

    public void setResultComment(String resultComment) {
        this.resultComment = resultComment == null ? null : resultComment.trim();
    }
}