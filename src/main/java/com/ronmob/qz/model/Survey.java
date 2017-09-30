package com.ronmob.qz.model;

import java.math.BigDecimal;
import java.util.Date;

public class Survey {
    private Integer id;

    private String title;

    private Integer createBy;

    private Date createTime;

    private Integer classId;

    private Byte status;

    private Integer questionCnt;

    private Byte estimateMinutes;

    private BigDecimal price;

    private BigDecimal orgPrice;

    private String image;

    private Byte isNeedSex;

    private Integer testedCnt;

    private String resultTemplate;

    private Byte isHot;

    private Byte isNew;

    private Byte isSuper;

    private String resultTemplateParam;

    private String shortDescription;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getQuestionCnt() {
        return questionCnt;
    }

    public void setQuestionCnt(Integer questionCnt) {
        this.questionCnt = questionCnt;
    }

    public Byte getEstimateMinutes() {
        return estimateMinutes;
    }

    public void setEstimateMinutes(Byte estimateMinutes) {
        this.estimateMinutes = estimateMinutes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(BigDecimal orgPrice) {
        this.orgPrice = orgPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Byte getIsNeedSex() {
        return isNeedSex;
    }

    public void setIsNeedSex(Byte isNeedSex) {
        this.isNeedSex = isNeedSex;
    }

    public Integer getTestedCnt() {
        return testedCnt;
    }

    public void setTestedCnt(Integer testedCnt) {
        this.testedCnt = testedCnt;
    }

    public String getResultTemplate() {
        return resultTemplate;
    }

    public void setResultTemplate(String resultTemplate) {
        this.resultTemplate = resultTemplate == null ? null : resultTemplate.trim();
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public Byte getIsNew() {
        return isNew;
    }

    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    public Byte getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Byte isSuper) {
        this.isSuper = isSuper;
    }

    public String getResultTemplateParam() {
        return resultTemplateParam;
    }

    public void setResultTemplateParam(String resultTemplateParam) {
        this.resultTemplateParam = resultTemplateParam == null ? null : resultTemplateParam.trim();
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription == null ? null : shortDescription.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}