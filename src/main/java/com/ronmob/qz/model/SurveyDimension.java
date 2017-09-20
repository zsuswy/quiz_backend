package com.ronmob.qz.model;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class SurveyDimension {
    private Integer id;
    private Integer parent_id;
    private Integer survey_id;
    private Integer seq;
    private String dimension_name;
    private Integer auto_calculate_type;
    private Integer proxy_sub_dimension_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Integer survey_id) {
        this.survey_id = survey_id;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getDimension_name() {
        return dimension_name;
    }

    public void setDimension_name(String dimension_name) {
        this.dimension_name = dimension_name;
    }

    public Integer getAuto_calculate_type() {
        return auto_calculate_type;
    }

    public void setAuto_calculate_type(Integer auto_calculate_type) {
        this.auto_calculate_type = auto_calculate_type;
    }

    public Integer getProxy_sub_dimension_id() {
        return proxy_sub_dimension_id;
    }

    public void setProxy_sub_dimension_id(Integer proxy_sub_dimension_id) {
        this.proxy_sub_dimension_id = proxy_sub_dimension_id;
    }
}
