package com.ronmob.qz.model;

import java.util.ArrayList;
import java.util.List;

public class SurveyDimensionScoreTextExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SurveyDimensionScoreTextExample() {
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

        public Criteria andDimensionIdIsNull() {
            addCriterion("dimension_id is null");
            return (Criteria) this;
        }

        public Criteria andDimensionIdIsNotNull() {
            addCriterion("dimension_id is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionIdEqualTo(Integer value) {
            addCriterion("dimension_id =", value, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdNotEqualTo(Integer value) {
            addCriterion("dimension_id <>", value, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdGreaterThan(Integer value) {
            addCriterion("dimension_id >", value, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dimension_id >=", value, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdLessThan(Integer value) {
            addCriterion("dimension_id <", value, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdLessThanOrEqualTo(Integer value) {
            addCriterion("dimension_id <=", value, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdIn(List<Integer> values) {
            addCriterion("dimension_id in", values, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdNotIn(List<Integer> values) {
            addCriterion("dimension_id not in", values, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdBetween(Integer value1, Integer value2) {
            addCriterion("dimension_id between", value1, value2, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andDimensionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dimension_id not between", value1, value2, "dimensionId");
            return (Criteria) this;
        }

        public Criteria andScoreMaxIsNull() {
            addCriterion("score_max is null");
            return (Criteria) this;
        }

        public Criteria andScoreMaxIsNotNull() {
            addCriterion("score_max is not null");
            return (Criteria) this;
        }

        public Criteria andScoreMaxEqualTo(Integer value) {
            addCriterion("score_max =", value, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxNotEqualTo(Integer value) {
            addCriterion("score_max <>", value, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxGreaterThan(Integer value) {
            addCriterion("score_max >", value, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_max >=", value, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxLessThan(Integer value) {
            addCriterion("score_max <", value, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxLessThanOrEqualTo(Integer value) {
            addCriterion("score_max <=", value, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxIn(List<Integer> values) {
            addCriterion("score_max in", values, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxNotIn(List<Integer> values) {
            addCriterion("score_max not in", values, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxBetween(Integer value1, Integer value2) {
            addCriterion("score_max between", value1, value2, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("score_max not between", value1, value2, "scoreMax");
            return (Criteria) this;
        }

        public Criteria andScoreMinIsNull() {
            addCriterion("score_min is null");
            return (Criteria) this;
        }

        public Criteria andScoreMinIsNotNull() {
            addCriterion("score_min is not null");
            return (Criteria) this;
        }

        public Criteria andScoreMinEqualTo(Integer value) {
            addCriterion("score_min =", value, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinNotEqualTo(Integer value) {
            addCriterion("score_min <>", value, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinGreaterThan(Integer value) {
            addCriterion("score_min >", value, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_min >=", value, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinLessThan(Integer value) {
            addCriterion("score_min <", value, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinLessThanOrEqualTo(Integer value) {
            addCriterion("score_min <=", value, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinIn(List<Integer> values) {
            addCriterion("score_min in", values, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinNotIn(List<Integer> values) {
            addCriterion("score_min not in", values, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinBetween(Integer value1, Integer value2) {
            addCriterion("score_min between", value1, value2, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andScoreMinNotBetween(Integer value1, Integer value2) {
            addCriterion("score_min not between", value1, value2, "scoreMin");
            return (Criteria) this;
        }

        public Criteria andResultTitleIsNull() {
            addCriterion("result_title is null");
            return (Criteria) this;
        }

        public Criteria andResultTitleIsNotNull() {
            addCriterion("result_title is not null");
            return (Criteria) this;
        }

        public Criteria andResultTitleEqualTo(String value) {
            addCriterion("result_title =", value, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleNotEqualTo(String value) {
            addCriterion("result_title <>", value, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleGreaterThan(String value) {
            addCriterion("result_title >", value, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleGreaterThanOrEqualTo(String value) {
            addCriterion("result_title >=", value, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleLessThan(String value) {
            addCriterion("result_title <", value, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleLessThanOrEqualTo(String value) {
            addCriterion("result_title <=", value, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleLike(String value) {
            addCriterion("result_title like", value, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleNotLike(String value) {
            addCriterion("result_title not like", value, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleIn(List<String> values) {
            addCriterion("result_title in", values, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleNotIn(List<String> values) {
            addCriterion("result_title not in", values, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleBetween(String value1, String value2) {
            addCriterion("result_title between", value1, value2, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andResultTitleNotBetween(String value1, String value2) {
            addCriterion("result_title not between", value1, value2, "resultTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyIdIsNull() {
            addCriterion("survey_id is null");
            return (Criteria) this;
        }

        public Criteria andSurveyIdIsNotNull() {
            addCriterion("survey_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyIdEqualTo(Integer value) {
            addCriterion("survey_id =", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdNotEqualTo(Integer value) {
            addCriterion("survey_id <>", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdGreaterThan(Integer value) {
            addCriterion("survey_id >", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("survey_id >=", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdLessThan(Integer value) {
            addCriterion("survey_id <", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdLessThanOrEqualTo(Integer value) {
            addCriterion("survey_id <=", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdIn(List<Integer> values) {
            addCriterion("survey_id in", values, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdNotIn(List<Integer> values) {
            addCriterion("survey_id not in", values, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdBetween(Integer value1, Integer value2) {
            addCriterion("survey_id between", value1, value2, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("survey_id not between", value1, value2, "surveyId");
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