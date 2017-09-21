package com.ronmob.qz.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SurveyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SurveyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andQuestionCntIsNull() {
            addCriterion("question_cnt is null");
            return (Criteria) this;
        }

        public Criteria andQuestionCntIsNotNull() {
            addCriterion("question_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionCntEqualTo(Integer value) {
            addCriterion("question_cnt =", value, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntNotEqualTo(Integer value) {
            addCriterion("question_cnt <>", value, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntGreaterThan(Integer value) {
            addCriterion("question_cnt >", value, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_cnt >=", value, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntLessThan(Integer value) {
            addCriterion("question_cnt <", value, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntLessThanOrEqualTo(Integer value) {
            addCriterion("question_cnt <=", value, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntIn(List<Integer> values) {
            addCriterion("question_cnt in", values, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntNotIn(List<Integer> values) {
            addCriterion("question_cnt not in", values, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntBetween(Integer value1, Integer value2) {
            addCriterion("question_cnt between", value1, value2, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andQuestionCntNotBetween(Integer value1, Integer value2) {
            addCriterion("question_cnt not between", value1, value2, "questionCnt");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesIsNull() {
            addCriterion("estimate_minutes is null");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesIsNotNull() {
            addCriterion("estimate_minutes is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesEqualTo(Byte value) {
            addCriterion("estimate_minutes =", value, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesNotEqualTo(Byte value) {
            addCriterion("estimate_minutes <>", value, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesGreaterThan(Byte value) {
            addCriterion("estimate_minutes >", value, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesGreaterThanOrEqualTo(Byte value) {
            addCriterion("estimate_minutes >=", value, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesLessThan(Byte value) {
            addCriterion("estimate_minutes <", value, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesLessThanOrEqualTo(Byte value) {
            addCriterion("estimate_minutes <=", value, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesIn(List<Byte> values) {
            addCriterion("estimate_minutes in", values, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesNotIn(List<Byte> values) {
            addCriterion("estimate_minutes not in", values, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesBetween(Byte value1, Byte value2) {
            addCriterion("estimate_minutes between", value1, value2, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andEstimateMinutesNotBetween(Byte value1, Byte value2) {
            addCriterion("estimate_minutes not between", value1, value2, "estimateMinutes");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andOrgPriceIsNull() {
            addCriterion("org_price is null");
            return (Criteria) this;
        }

        public Criteria andOrgPriceIsNotNull() {
            addCriterion("org_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPriceEqualTo(BigDecimal value) {
            addCriterion("org_price =", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceNotEqualTo(BigDecimal value) {
            addCriterion("org_price <>", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceGreaterThan(BigDecimal value) {
            addCriterion("org_price >", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("org_price >=", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceLessThan(BigDecimal value) {
            addCriterion("org_price <", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("org_price <=", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceIn(List<BigDecimal> values) {
            addCriterion("org_price in", values, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceNotIn(List<BigDecimal> values) {
            addCriterion("org_price not in", values, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("org_price between", value1, value2, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("org_price not between", value1, value2, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexIsNull() {
            addCriterion("is_need_sex is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexIsNotNull() {
            addCriterion("is_need_sex is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexEqualTo(Byte value) {
            addCriterion("is_need_sex =", value, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexNotEqualTo(Byte value) {
            addCriterion("is_need_sex <>", value, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexGreaterThan(Byte value) {
            addCriterion("is_need_sex >", value, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_need_sex >=", value, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexLessThan(Byte value) {
            addCriterion("is_need_sex <", value, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexLessThanOrEqualTo(Byte value) {
            addCriterion("is_need_sex <=", value, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexIn(List<Byte> values) {
            addCriterion("is_need_sex in", values, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexNotIn(List<Byte> values) {
            addCriterion("is_need_sex not in", values, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexBetween(Byte value1, Byte value2) {
            addCriterion("is_need_sex between", value1, value2, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andIsNeedSexNotBetween(Byte value1, Byte value2) {
            addCriterion("is_need_sex not between", value1, value2, "isNeedSex");
            return (Criteria) this;
        }

        public Criteria andTestedCntIsNull() {
            addCriterion("tested_cnt is null");
            return (Criteria) this;
        }

        public Criteria andTestedCntIsNotNull() {
            addCriterion("tested_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andTestedCntEqualTo(Integer value) {
            addCriterion("tested_cnt =", value, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntNotEqualTo(Integer value) {
            addCriterion("tested_cnt <>", value, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntGreaterThan(Integer value) {
            addCriterion("tested_cnt >", value, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("tested_cnt >=", value, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntLessThan(Integer value) {
            addCriterion("tested_cnt <", value, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntLessThanOrEqualTo(Integer value) {
            addCriterion("tested_cnt <=", value, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntIn(List<Integer> values) {
            addCriterion("tested_cnt in", values, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntNotIn(List<Integer> values) {
            addCriterion("tested_cnt not in", values, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntBetween(Integer value1, Integer value2) {
            addCriterion("tested_cnt between", value1, value2, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andTestedCntNotBetween(Integer value1, Integer value2) {
            addCriterion("tested_cnt not between", value1, value2, "testedCnt");
            return (Criteria) this;
        }

        public Criteria andResultTemplateIsNull() {
            addCriterion("result_template is null");
            return (Criteria) this;
        }

        public Criteria andResultTemplateIsNotNull() {
            addCriterion("result_template is not null");
            return (Criteria) this;
        }

        public Criteria andResultTemplateEqualTo(String value) {
            addCriterion("result_template =", value, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateNotEqualTo(String value) {
            addCriterion("result_template <>", value, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateGreaterThan(String value) {
            addCriterion("result_template >", value, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("result_template >=", value, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateLessThan(String value) {
            addCriterion("result_template <", value, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateLessThanOrEqualTo(String value) {
            addCriterion("result_template <=", value, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateLike(String value) {
            addCriterion("result_template like", value, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateNotLike(String value) {
            addCriterion("result_template not like", value, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateIn(List<String> values) {
            addCriterion("result_template in", values, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateNotIn(List<String> values) {
            addCriterion("result_template not in", values, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateBetween(String value1, String value2) {
            addCriterion("result_template between", value1, value2, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andResultTemplateNotBetween(String value1, String value2) {
            addCriterion("result_template not between", value1, value2, "resultTemplate");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(Byte value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(Byte value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(Byte value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(Byte value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(Byte value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<Byte> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<Byte> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(Byte value1, Byte value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(Byte value1, Byte value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNull() {
            addCriterion("is_new is null");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNotNull() {
            addCriterion("is_new is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewEqualTo(Byte value) {
            addCriterion("is_new =", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotEqualTo(Byte value) {
            addCriterion("is_new <>", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThan(Byte value) {
            addCriterion("is_new >", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_new >=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThan(Byte value) {
            addCriterion("is_new <", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThanOrEqualTo(Byte value) {
            addCriterion("is_new <=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewIn(List<Byte> values) {
            addCriterion("is_new in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotIn(List<Byte> values) {
            addCriterion("is_new not in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewBetween(Byte value1, Byte value2) {
            addCriterion("is_new between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotBetween(Byte value1, Byte value2) {
            addCriterion("is_new not between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsSuperIsNull() {
            addCriterion("is_super is null");
            return (Criteria) this;
        }

        public Criteria andIsSuperIsNotNull() {
            addCriterion("is_super is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuperEqualTo(Byte value) {
            addCriterion("is_super =", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperNotEqualTo(Byte value) {
            addCriterion("is_super <>", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperGreaterThan(Byte value) {
            addCriterion("is_super >", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_super >=", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperLessThan(Byte value) {
            addCriterion("is_super <", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperLessThanOrEqualTo(Byte value) {
            addCriterion("is_super <=", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperIn(List<Byte> values) {
            addCriterion("is_super in", values, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperNotIn(List<Byte> values) {
            addCriterion("is_super not in", values, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperBetween(Byte value1, Byte value2) {
            addCriterion("is_super between", value1, value2, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperNotBetween(Byte value1, Byte value2) {
            addCriterion("is_super not between", value1, value2, "isSuper");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamIsNull() {
            addCriterion("result_template_param is null");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamIsNotNull() {
            addCriterion("result_template_param is not null");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamEqualTo(String value) {
            addCriterion("result_template_param =", value, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamNotEqualTo(String value) {
            addCriterion("result_template_param <>", value, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamGreaterThan(String value) {
            addCriterion("result_template_param >", value, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamGreaterThanOrEqualTo(String value) {
            addCriterion("result_template_param >=", value, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamLessThan(String value) {
            addCriterion("result_template_param <", value, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamLessThanOrEqualTo(String value) {
            addCriterion("result_template_param <=", value, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamLike(String value) {
            addCriterion("result_template_param like", value, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamNotLike(String value) {
            addCriterion("result_template_param not like", value, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamIn(List<String> values) {
            addCriterion("result_template_param in", values, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamNotIn(List<String> values) {
            addCriterion("result_template_param not in", values, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamBetween(String value1, String value2) {
            addCriterion("result_template_param between", value1, value2, "resultTemplateParam");
            return (Criteria) this;
        }

        public Criteria andResultTemplateParamNotBetween(String value1, String value2) {
            addCriterion("result_template_param not between", value1, value2, "resultTemplateParam");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}