package com.baodanwang.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNull() {
            addCriterion("order_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNotNull() {
            addCriterion("order_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressEqualTo(String value) {
            addCriterion("order_address =", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotEqualTo(String value) {
            addCriterion("order_address <>", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThan(String value) {
            addCriterion("order_address >", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_address >=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThan(String value) {
            addCriterion("order_address <", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThanOrEqualTo(String value) {
            addCriterion("order_address <=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLike(String value) {
            addCriterion("order_address like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotLike(String value) {
            addCriterion("order_address not like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIn(List<String> values) {
            addCriterion("order_address in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotIn(List<String> values) {
            addCriterion("order_address not in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressBetween(String value1, String value2) {
            addCriterion("order_address between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotBetween(String value1, String value2) {
            addCriterion("order_address not between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderTelIsNull() {
            addCriterion("order_tel is null");
            return (Criteria) this;
        }

        public Criteria andOrderTelIsNotNull() {
            addCriterion("order_tel is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTelEqualTo(String value) {
            addCriterion("order_tel =", value, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelNotEqualTo(String value) {
            addCriterion("order_tel <>", value, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelGreaterThan(String value) {
            addCriterion("order_tel >", value, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelGreaterThanOrEqualTo(String value) {
            addCriterion("order_tel >=", value, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelLessThan(String value) {
            addCriterion("order_tel <", value, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelLessThanOrEqualTo(String value) {
            addCriterion("order_tel <=", value, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelLike(String value) {
            addCriterion("order_tel like", value, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelNotLike(String value) {
            addCriterion("order_tel not like", value, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelIn(List<String> values) {
            addCriterion("order_tel in", values, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelNotIn(List<String> values) {
            addCriterion("order_tel not in", values, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelBetween(String value1, String value2) {
            addCriterion("order_tel between", value1, value2, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderTelNotBetween(String value1, String value2) {
            addCriterion("order_tel not between", value1, value2, "orderTel");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNull() {
            addCriterion("order_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("order_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("order_name =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("order_name <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("order_name >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_name >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("order_name <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("order_name <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("order_name like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("order_name not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("order_name in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("order_name not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("order_name between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("order_name not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidIsNull() {
            addCriterion("order_weChatId is null");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidIsNotNull() {
            addCriterion("order_weChatId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidEqualTo(String value) {
            addCriterion("order_weChatId =", value, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidNotEqualTo(String value) {
            addCriterion("order_weChatId <>", value, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidGreaterThan(String value) {
            addCriterion("order_weChatId >", value, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidGreaterThanOrEqualTo(String value) {
            addCriterion("order_weChatId >=", value, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidLessThan(String value) {
            addCriterion("order_weChatId <", value, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidLessThanOrEqualTo(String value) {
            addCriterion("order_weChatId <=", value, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidLike(String value) {
            addCriterion("order_weChatId like", value, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidNotLike(String value) {
            addCriterion("order_weChatId not like", value, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidIn(List<String> values) {
            addCriterion("order_weChatId in", values, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidNotIn(List<String> values) {
            addCriterion("order_weChatId not in", values, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidBetween(String value1, String value2) {
            addCriterion("order_weChatId between", value1, value2, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderWechatidNotBetween(String value1, String value2) {
            addCriterion("order_weChatId not between", value1, value2, "orderWechatid");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceIsNull() {
            addCriterion("order_totalPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceIsNotNull() {
            addCriterion("order_totalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceEqualTo(String value) {
            addCriterion("order_totalPrice =", value, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceNotEqualTo(String value) {
            addCriterion("order_totalPrice <>", value, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceGreaterThan(String value) {
            addCriterion("order_totalPrice >", value, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceGreaterThanOrEqualTo(String value) {
            addCriterion("order_totalPrice >=", value, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceLessThan(String value) {
            addCriterion("order_totalPrice <", value, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceLessThanOrEqualTo(String value) {
            addCriterion("order_totalPrice <=", value, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceLike(String value) {
            addCriterion("order_totalPrice like", value, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceNotLike(String value) {
            addCriterion("order_totalPrice not like", value, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceIn(List<String> values) {
            addCriterion("order_totalPrice in", values, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceNotIn(List<String> values) {
            addCriterion("order_totalPrice not in", values, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceBetween(String value1, String value2) {
            addCriterion("order_totalPrice between", value1, value2, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalpriceNotBetween(String value1, String value2) {
            addCriterion("order_totalPrice not between", value1, value2, "orderTotalprice");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andOrderNotesIsNull() {
            addCriterion("order_notes is null");
            return (Criteria) this;
        }

        public Criteria andOrderNotesIsNotNull() {
            addCriterion("order_notes is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNotesEqualTo(String value) {
            addCriterion("order_notes =", value, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesNotEqualTo(String value) {
            addCriterion("order_notes <>", value, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesGreaterThan(String value) {
            addCriterion("order_notes >", value, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesGreaterThanOrEqualTo(String value) {
            addCriterion("order_notes >=", value, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesLessThan(String value) {
            addCriterion("order_notes <", value, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesLessThanOrEqualTo(String value) {
            addCriterion("order_notes <=", value, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesLike(String value) {
            addCriterion("order_notes like", value, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesNotLike(String value) {
            addCriterion("order_notes not like", value, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesIn(List<String> values) {
            addCriterion("order_notes in", values, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesNotIn(List<String> values) {
            addCriterion("order_notes not in", values, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesBetween(String value1, String value2) {
            addCriterion("order_notes between", value1, value2, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderNotesNotBetween(String value1, String value2) {
            addCriterion("order_notes not between", value1, value2, "orderNotes");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailIsNull() {
            addCriterion("order_addressDetail is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailIsNotNull() {
            addCriterion("order_addressDetail is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailEqualTo(String value) {
            addCriterion("order_addressDetail =", value, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailNotEqualTo(String value) {
            addCriterion("order_addressDetail <>", value, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailGreaterThan(String value) {
            addCriterion("order_addressDetail >", value, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailGreaterThanOrEqualTo(String value) {
            addCriterion("order_addressDetail >=", value, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailLessThan(String value) {
            addCriterion("order_addressDetail <", value, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailLessThanOrEqualTo(String value) {
            addCriterion("order_addressDetail <=", value, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailLike(String value) {
            addCriterion("order_addressDetail like", value, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailNotLike(String value) {
            addCriterion("order_addressDetail not like", value, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailIn(List<String> values) {
            addCriterion("order_addressDetail in", values, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailNotIn(List<String> values) {
            addCriterion("order_addressDetail not in", values, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailBetween(String value1, String value2) {
            addCriterion("order_addressDetail between", value1, value2, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddressdetailNotBetween(String value1, String value2) {
            addCriterion("order_addressDetail not between", value1, value2, "orderAddressdetail");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeIsNull() {
            addCriterion("order_addTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeIsNotNull() {
            addCriterion("order_addTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeEqualTo(String value) {
            addCriterion("order_addTime =", value, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeNotEqualTo(String value) {
            addCriterion("order_addTime <>", value, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeGreaterThan(String value) {
            addCriterion("order_addTime >", value, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_addTime >=", value, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeLessThan(String value) {
            addCriterion("order_addTime <", value, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeLessThanOrEqualTo(String value) {
            addCriterion("order_addTime <=", value, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeLike(String value) {
            addCriterion("order_addTime like", value, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeNotLike(String value) {
            addCriterion("order_addTime not like", value, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeIn(List<String> values) {
            addCriterion("order_addTime in", values, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeNotIn(List<String> values) {
            addCriterion("order_addTime not in", values, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeBetween(String value1, String value2) {
            addCriterion("order_addTime between", value1, value2, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderAddtimeNotBetween(String value1, String value2) {
            addCriterion("order_addTime not between", value1, value2, "orderAddtime");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayIsNull() {
            addCriterion("order_pickupWay is null");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayIsNotNull() {
            addCriterion("order_pickupWay is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayEqualTo(String value) {
            addCriterion("order_pickupWay =", value, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayNotEqualTo(String value) {
            addCriterion("order_pickupWay <>", value, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayGreaterThan(String value) {
            addCriterion("order_pickupWay >", value, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayGreaterThanOrEqualTo(String value) {
            addCriterion("order_pickupWay >=", value, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayLessThan(String value) {
            addCriterion("order_pickupWay <", value, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayLessThanOrEqualTo(String value) {
            addCriterion("order_pickupWay <=", value, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayLike(String value) {
            addCriterion("order_pickupWay like", value, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayNotLike(String value) {
            addCriterion("order_pickupWay not like", value, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayIn(List<String> values) {
            addCriterion("order_pickupWay in", values, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayNotIn(List<String> values) {
            addCriterion("order_pickupWay not in", values, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayBetween(String value1, String value2) {
            addCriterion("order_pickupWay between", value1, value2, "orderPickupway");
            return (Criteria) this;
        }

        public Criteria andOrderPickupwayNotBetween(String value1, String value2) {
            addCriterion("order_pickupWay not between", value1, value2, "orderPickupway");
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