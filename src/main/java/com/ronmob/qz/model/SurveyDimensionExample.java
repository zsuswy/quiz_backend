package com.ronmob.qz.model;

import java.util.ArrayList;
import java.util.List;

public class SurveyDimensionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SurveyDimensionExample() {
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Integer value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Integer value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Integer value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Integer value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Integer value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Integer> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Integer> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Integer value1, Integer value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("seq not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andDimensionNameIsNull() {
            addCriterion("dimension_name is null");
            return (Criteria) this;
        }

        public Criteria andDimensionNameIsNotNull() {
            addCriterion("dimension_name is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionNameEqualTo(String value) {
            addCriterion("dimension_name =", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameNotEqualTo(String value) {
            addCriterion("dimension_name <>", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameGreaterThan(String value) {
            addCriterion("dimension_name >", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameGreaterThanOrEqualTo(String value) {
            addCriterion("dimension_name >=", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameLessThan(String value) {
            addCriterion("dimension_name <", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameLessThanOrEqualTo(String value) {
            addCriterion("dimension_name <=", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameLike(String value) {
            addCriterion("dimension_name like", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameNotLike(String value) {
            addCriterion("dimension_name not like", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameIn(List<String> values) {
            addCriterion("dimension_name in", values, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameNotIn(List<String> values) {
            addCriterion("dimension_name not in", values, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameBetween(String value1, String value2) {
            addCriterion("dimension_name between", value1, value2, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameNotBetween(String value1, String value2) {
            addCriterion("dimension_name not between", value1, value2, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeIsNull() {
            addCriterion("auto_calculate_type is null");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeIsNotNull() {
            addCriterion("auto_calculate_type is not null");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeEqualTo(Byte value) {
            addCriterion("auto_calculate_type =", value, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeNotEqualTo(Byte value) {
            addCriterion("auto_calculate_type <>", value, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeGreaterThan(Byte value) {
            addCriterion("auto_calculate_type >", value, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("auto_calculate_type >=", value, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeLessThan(Byte value) {
            addCriterion("auto_calculate_type <", value, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("auto_calculate_type <=", value, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeIn(List<Byte> values) {
            addCriterion("auto_calculate_type in", values, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeNotIn(List<Byte> values) {
            addCriterion("auto_calculate_type not in", values, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeBetween(Byte value1, Byte value2) {
            addCriterion("auto_calculate_type between", value1, value2, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andAutoCalculateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("auto_calculate_type not between", value1, value2, "autoCalculateType");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdIsNull() {
            addCriterion("proxy_sub_dimension_id is null");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdIsNotNull() {
            addCriterion("proxy_sub_dimension_id is not null");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdEqualTo(Integer value) {
            addCriterion("proxy_sub_dimension_id =", value, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdNotEqualTo(Integer value) {
            addCriterion("proxy_sub_dimension_id <>", value, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdGreaterThan(Integer value) {
            addCriterion("proxy_sub_dimension_id >", value, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("proxy_sub_dimension_id >=", value, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdLessThan(Integer value) {
            addCriterion("proxy_sub_dimension_id <", value, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdLessThanOrEqualTo(Integer value) {
            addCriterion("proxy_sub_dimension_id <=", value, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdIn(List<Integer> values) {
            addCriterion("proxy_sub_dimension_id in", values, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdNotIn(List<Integer> values) {
            addCriterion("proxy_sub_dimension_id not in", values, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdBetween(Integer value1, Integer value2) {
            addCriterion("proxy_sub_dimension_id between", value1, value2, "proxySubDimensionId");
            return (Criteria) this;
        }

        public Criteria andProxySubDimensionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("proxy_sub_dimension_id not between", value1, value2, "proxySubDimensionId");
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