package com.baodanwang.pojo;

import java.util.ArrayList;
import java.util.List;

public class BulksandgoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BulksandgoodsExample() {
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

        public Criteria andBgIdIsNull() {
            addCriterion("bg_id is null");
            return (Criteria) this;
        }

        public Criteria andBgIdIsNotNull() {
            addCriterion("bg_id is not null");
            return (Criteria) this;
        }

        public Criteria andBgIdEqualTo(String value) {
            addCriterion("bg_id =", value, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdNotEqualTo(String value) {
            addCriterion("bg_id <>", value, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdGreaterThan(String value) {
            addCriterion("bg_id >", value, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdGreaterThanOrEqualTo(String value) {
            addCriterion("bg_id >=", value, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdLessThan(String value) {
            addCriterion("bg_id <", value, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdLessThanOrEqualTo(String value) {
            addCriterion("bg_id <=", value, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdLike(String value) {
            addCriterion("bg_id like", value, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdNotLike(String value) {
            addCriterion("bg_id not like", value, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdIn(List<String> values) {
            addCriterion("bg_id in", values, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdNotIn(List<String> values) {
            addCriterion("bg_id not in", values, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdBetween(String value1, String value2) {
            addCriterion("bg_id between", value1, value2, "bgId");
            return (Criteria) this;
        }

        public Criteria andBgIdNotBetween(String value1, String value2) {
            addCriterion("bg_id not between", value1, value2, "bgId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNull() {
            addCriterion("good_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("good_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(String value) {
            addCriterion("good_id =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(String value) {
            addCriterion("good_id <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(String value) {
            addCriterion("good_id >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(String value) {
            addCriterion("good_id >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(String value) {
            addCriterion("good_id <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(String value) {
            addCriterion("good_id <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLike(String value) {
            addCriterion("good_id like", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotLike(String value) {
            addCriterion("good_id not like", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<String> values) {
            addCriterion("good_id in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<String> values) {
            addCriterion("good_id not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(String value1, String value2) {
            addCriterion("good_id between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(String value1, String value2) {
            addCriterion("good_id not between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andBulkIdIsNull() {
            addCriterion("bulk_id is null");
            return (Criteria) this;
        }

        public Criteria andBulkIdIsNotNull() {
            addCriterion("bulk_id is not null");
            return (Criteria) this;
        }

        public Criteria andBulkIdEqualTo(String value) {
            addCriterion("bulk_id =", value, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdNotEqualTo(String value) {
            addCriterion("bulk_id <>", value, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdGreaterThan(String value) {
            addCriterion("bulk_id >", value, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdGreaterThanOrEqualTo(String value) {
            addCriterion("bulk_id >=", value, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdLessThan(String value) {
            addCriterion("bulk_id <", value, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdLessThanOrEqualTo(String value) {
            addCriterion("bulk_id <=", value, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdLike(String value) {
            addCriterion("bulk_id like", value, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdNotLike(String value) {
            addCriterion("bulk_id not like", value, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdIn(List<String> values) {
            addCriterion("bulk_id in", values, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdNotIn(List<String> values) {
            addCriterion("bulk_id not in", values, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdBetween(String value1, String value2) {
            addCriterion("bulk_id between", value1, value2, "bulkId");
            return (Criteria) this;
        }

        public Criteria andBulkIdNotBetween(String value1, String value2) {
            addCriterion("bulk_id not between", value1, value2, "bulkId");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteIsNull() {
            addCriterion("good_limite is null");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteIsNotNull() {
            addCriterion("good_limite is not null");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteEqualTo(String value) {
            addCriterion("good_limite =", value, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteNotEqualTo(String value) {
            addCriterion("good_limite <>", value, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteGreaterThan(String value) {
            addCriterion("good_limite >", value, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteGreaterThanOrEqualTo(String value) {
            addCriterion("good_limite >=", value, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteLessThan(String value) {
            addCriterion("good_limite <", value, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteLessThanOrEqualTo(String value) {
            addCriterion("good_limite <=", value, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteLike(String value) {
            addCriterion("good_limite like", value, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteNotLike(String value) {
            addCriterion("good_limite not like", value, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteIn(List<String> values) {
            addCriterion("good_limite in", values, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteNotIn(List<String> values) {
            addCriterion("good_limite not in", values, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteBetween(String value1, String value2) {
            addCriterion("good_limite between", value1, value2, "goodLimite");
            return (Criteria) this;
        }

        public Criteria andGoodLimiteNotBetween(String value1, String value2) {
            addCriterion("good_limite not between", value1, value2, "goodLimite");
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