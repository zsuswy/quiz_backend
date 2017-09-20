package com.ronmob.qz.model;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class SurveyDimensionScoreText {
    private Integer id;
    private Integer dimension_id;
    private Integer score_max;
    private Integer score_min;
    private String result_title;
    private String result_comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDimension_id() {
        return dimension_id;
    }

    public void setDimension_id(Integer dimension_id) {
        this.dimension_id = dimension_id;
    }

    public Integer getScore_max() {
        return score_max;
    }

    public void setScore_max(Integer score_max) {
        this.score_max = score_max;
    }

    public Integer getScore_min() {
        return score_min;
    }

    public void setScore_min(Integer score_min) {
        this.score_min = score_min;
    }

    public String getResult_title() {
        return result_title;
    }

    public void setResult_title(String result_title) {
        this.result_title = result_title;
    }

    public String getResult_comment() {
        return result_comment;
    }

    public void setResult_comment(String result_comment) {
        this.result_comment = result_comment;
    }
}
