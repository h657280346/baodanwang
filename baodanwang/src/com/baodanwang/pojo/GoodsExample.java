package com.baodanwang.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(String value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(String value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(String value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(String value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(String value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLike(String value) {
            addCriterion("store_id like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotLike(String value) {
            addCriterion("store_id not like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<String> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<String> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(String value1, String value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(String value1, String value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNull() {
            addCriterion("good_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNotNull() {
            addCriterion("good_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNameEqualTo(String value) {
            addCriterion("good_name =", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotEqualTo(String value) {
            addCriterion("good_name <>", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThan(String value) {
            addCriterion("good_name >", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_name >=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThan(String value) {
            addCriterion("good_name <", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThanOrEqualTo(String value) {
            addCriterion("good_name <=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLike(String value) {
            addCriterion("good_name like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotLike(String value) {
            addCriterion("good_name not like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameIn(List<String> values) {
            addCriterion("good_name in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotIn(List<String> values) {
            addCriterion("good_name not in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameBetween(String value1, String value2) {
            addCriterion("good_name between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotBetween(String value1, String value2) {
            addCriterion("good_name not between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusIsNull() {
            addCriterion("good_showStatus is null");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusIsNotNull() {
            addCriterion("good_showStatus is not null");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusEqualTo(String value) {
            addCriterion("good_showStatus =", value, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusNotEqualTo(String value) {
            addCriterion("good_showStatus <>", value, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusGreaterThan(String value) {
            addCriterion("good_showStatus >", value, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusGreaterThanOrEqualTo(String value) {
            addCriterion("good_showStatus >=", value, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusLessThan(String value) {
            addCriterion("good_showStatus <", value, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusLessThanOrEqualTo(String value) {
            addCriterion("good_showStatus <=", value, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusLike(String value) {
            addCriterion("good_showStatus like", value, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusNotLike(String value) {
            addCriterion("good_showStatus not like", value, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusIn(List<String> values) {
            addCriterion("good_showStatus in", values, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusNotIn(List<String> values) {
            addCriterion("good_showStatus not in", values, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusBetween(String value1, String value2) {
            addCriterion("good_showStatus between", value1, value2, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodShowstatusNotBetween(String value1, String value2) {
            addCriterion("good_showStatus not between", value1, value2, "goodShowstatus");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNull() {
            addCriterion("good_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNotNull() {
            addCriterion("good_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceEqualTo(String value) {
            addCriterion("good_price =", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotEqualTo(String value) {
            addCriterion("good_price <>", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThan(String value) {
            addCriterion("good_price >", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThanOrEqualTo(String value) {
            addCriterion("good_price >=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThan(String value) {
            addCriterion("good_price <", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThanOrEqualTo(String value) {
            addCriterion("good_price <=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLike(String value) {
            addCriterion("good_price like", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotLike(String value) {
            addCriterion("good_price not like", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIn(List<String> values) {
            addCriterion("good_price in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotIn(List<String> values) {
            addCriterion("good_price not in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceBetween(String value1, String value2) {
            addCriterion("good_price between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotBetween(String value1, String value2) {
            addCriterion("good_price not between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceIsNull() {
            addCriterion("good_advancePrice is null");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceIsNotNull() {
            addCriterion("good_advancePrice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceEqualTo(String value) {
            addCriterion("good_advancePrice =", value, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceNotEqualTo(String value) {
            addCriterion("good_advancePrice <>", value, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceGreaterThan(String value) {
            addCriterion("good_advancePrice >", value, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceGreaterThanOrEqualTo(String value) {
            addCriterion("good_advancePrice >=", value, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceLessThan(String value) {
            addCriterion("good_advancePrice <", value, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceLessThanOrEqualTo(String value) {
            addCriterion("good_advancePrice <=", value, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceLike(String value) {
            addCriterion("good_advancePrice like", value, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceNotLike(String value) {
            addCriterion("good_advancePrice not like", value, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceIn(List<String> values) {
            addCriterion("good_advancePrice in", values, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceNotIn(List<String> values) {
            addCriterion("good_advancePrice not in", values, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceBetween(String value1, String value2) {
            addCriterion("good_advancePrice between", value1, value2, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodAdvancepriceNotBetween(String value1, String value2) {
            addCriterion("good_advancePrice not between", value1, value2, "goodAdvanceprice");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeIsNull() {
            addCriterion("good_describe is null");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeIsNotNull() {
            addCriterion("good_describe is not null");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeEqualTo(String value) {
            addCriterion("good_describe =", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeNotEqualTo(String value) {
            addCriterion("good_describe <>", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeGreaterThan(String value) {
            addCriterion("good_describe >", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("good_describe >=", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeLessThan(String value) {
            addCriterion("good_describe <", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeLessThanOrEqualTo(String value) {
            addCriterion("good_describe <=", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeLike(String value) {
            addCriterion("good_describe like", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeNotLike(String value) {
            addCriterion("good_describe not like", value, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeIn(List<String> values) {
            addCriterion("good_describe in", values, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeNotIn(List<String> values) {
            addCriterion("good_describe not in", values, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeBetween(String value1, String value2) {
            addCriterion("good_describe between", value1, value2, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodDescribeNotBetween(String value1, String value2) {
            addCriterion("good_describe not between", value1, value2, "goodDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeIsNull() {
            addCriterion("good_addTime is null");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeIsNotNull() {
            addCriterion("good_addTime is not null");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeEqualTo(String value) {
            addCriterion("good_addTime =", value, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeNotEqualTo(String value) {
            addCriterion("good_addTime <>", value, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeGreaterThan(String value) {
            addCriterion("good_addTime >", value, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("good_addTime >=", value, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeLessThan(String value) {
            addCriterion("good_addTime <", value, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeLessThanOrEqualTo(String value) {
            addCriterion("good_addTime <=", value, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeLike(String value) {
            addCriterion("good_addTime like", value, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeNotLike(String value) {
            addCriterion("good_addTime not like", value, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeIn(List<String> values) {
            addCriterion("good_addTime in", values, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeNotIn(List<String> values) {
            addCriterion("good_addTime not in", values, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeBetween(String value1, String value2) {
            addCriterion("good_addTime between", value1, value2, "goodAddtime");
            return (Criteria) this;
        }

        public Criteria andGoodAddtimeNotBetween(String value1, String value2) {
            addCriterion("good_addTime not between", value1, value2, "goodAddtime");
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