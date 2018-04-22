package com.baodanwang.pojo;

import java.util.ArrayList;
import java.util.List;

public class StoresExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoresExample() {
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

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlIsNull() {
            addCriterion("store_avatarUrl is null");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlIsNotNull() {
            addCriterion("store_avatarUrl is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlEqualTo(String value) {
            addCriterion("store_avatarUrl =", value, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlNotEqualTo(String value) {
            addCriterion("store_avatarUrl <>", value, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlGreaterThan(String value) {
            addCriterion("store_avatarUrl >", value, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlGreaterThanOrEqualTo(String value) {
            addCriterion("store_avatarUrl >=", value, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlLessThan(String value) {
            addCriterion("store_avatarUrl <", value, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlLessThanOrEqualTo(String value) {
            addCriterion("store_avatarUrl <=", value, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlLike(String value) {
            addCriterion("store_avatarUrl like", value, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlNotLike(String value) {
            addCriterion("store_avatarUrl not like", value, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlIn(List<String> values) {
            addCriterion("store_avatarUrl in", values, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlNotIn(List<String> values) {
            addCriterion("store_avatarUrl not in", values, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlBetween(String value1, String value2) {
            addCriterion("store_avatarUrl between", value1, value2, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreAvatarurlNotBetween(String value1, String value2) {
            addCriterion("store_avatarUrl not between", value1, value2, "storeAvatarurl");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusIsNull() {
            addCriterion("store_realNameStatus is null");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusIsNotNull() {
            addCriterion("store_realNameStatus is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusEqualTo(String value) {
            addCriterion("store_realNameStatus =", value, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusNotEqualTo(String value) {
            addCriterion("store_realNameStatus <>", value, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusGreaterThan(String value) {
            addCriterion("store_realNameStatus >", value, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusGreaterThanOrEqualTo(String value) {
            addCriterion("store_realNameStatus >=", value, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusLessThan(String value) {
            addCriterion("store_realNameStatus <", value, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusLessThanOrEqualTo(String value) {
            addCriterion("store_realNameStatus <=", value, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusLike(String value) {
            addCriterion("store_realNameStatus like", value, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusNotLike(String value) {
            addCriterion("store_realNameStatus not like", value, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusIn(List<String> values) {
            addCriterion("store_realNameStatus in", values, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusNotIn(List<String> values) {
            addCriterion("store_realNameStatus not in", values, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusBetween(String value1, String value2) {
            addCriterion("store_realNameStatus between", value1, value2, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreRealnamestatusNotBetween(String value1, String value2) {
            addCriterion("store_realNameStatus not between", value1, value2, "storeRealnamestatus");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidIsNull() {
            addCriterion("store_weChatId is null");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidIsNotNull() {
            addCriterion("store_weChatId is not null");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidEqualTo(String value) {
            addCriterion("store_weChatId =", value, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidNotEqualTo(String value) {
            addCriterion("store_weChatId <>", value, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidGreaterThan(String value) {
            addCriterion("store_weChatId >", value, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidGreaterThanOrEqualTo(String value) {
            addCriterion("store_weChatId >=", value, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidLessThan(String value) {
            addCriterion("store_weChatId <", value, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidLessThanOrEqualTo(String value) {
            addCriterion("store_weChatId <=", value, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidLike(String value) {
            addCriterion("store_weChatId like", value, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidNotLike(String value) {
            addCriterion("store_weChatId not like", value, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidIn(List<String> values) {
            addCriterion("store_weChatId in", values, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidNotIn(List<String> values) {
            addCriterion("store_weChatId not in", values, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidBetween(String value1, String value2) {
            addCriterion("store_weChatId between", value1, value2, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreWechatidNotBetween(String value1, String value2) {
            addCriterion("store_weChatId not between", value1, value2, "storeWechatid");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeIsNull() {
            addCriterion("store_QRCode is null");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeIsNotNull() {
            addCriterion("store_QRCode is not null");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeEqualTo(String value) {
            addCriterion("store_QRCode =", value, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeNotEqualTo(String value) {
            addCriterion("store_QRCode <>", value, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeGreaterThan(String value) {
            addCriterion("store_QRCode >", value, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("store_QRCode >=", value, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeLessThan(String value) {
            addCriterion("store_QRCode <", value, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeLessThanOrEqualTo(String value) {
            addCriterion("store_QRCode <=", value, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeLike(String value) {
            addCriterion("store_QRCode like", value, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeNotLike(String value) {
            addCriterion("store_QRCode not like", value, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeIn(List<String> values) {
            addCriterion("store_QRCode in", values, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeNotIn(List<String> values) {
            addCriterion("store_QRCode not in", values, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeBetween(String value1, String value2) {
            addCriterion("store_QRCode between", value1, value2, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreQrcodeNotBetween(String value1, String value2) {
            addCriterion("store_QRCode not between", value1, value2, "storeQrcode");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameIsNull() {
            addCriterion("store_realName is null");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameIsNotNull() {
            addCriterion("store_realName is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameEqualTo(String value) {
            addCriterion("store_realName =", value, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameNotEqualTo(String value) {
            addCriterion("store_realName <>", value, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameGreaterThan(String value) {
            addCriterion("store_realName >", value, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("store_realName >=", value, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameLessThan(String value) {
            addCriterion("store_realName <", value, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameLessThanOrEqualTo(String value) {
            addCriterion("store_realName <=", value, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameLike(String value) {
            addCriterion("store_realName like", value, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameNotLike(String value) {
            addCriterion("store_realName not like", value, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameIn(List<String> values) {
            addCriterion("store_realName in", values, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameNotIn(List<String> values) {
            addCriterion("store_realName not in", values, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameBetween(String value1, String value2) {
            addCriterion("store_realName between", value1, value2, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreRealnameNotBetween(String value1, String value2) {
            addCriterion("store_realName not between", value1, value2, "storeRealname");
            return (Criteria) this;
        }

        public Criteria andStoreTelIsNull() {
            addCriterion("store_tel is null");
            return (Criteria) this;
        }

        public Criteria andStoreTelIsNotNull() {
            addCriterion("store_tel is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTelEqualTo(String value) {
            addCriterion("store_tel =", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotEqualTo(String value) {
            addCriterion("store_tel <>", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelGreaterThan(String value) {
            addCriterion("store_tel >", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelGreaterThanOrEqualTo(String value) {
            addCriterion("store_tel >=", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLessThan(String value) {
            addCriterion("store_tel <", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLessThanOrEqualTo(String value) {
            addCriterion("store_tel <=", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLike(String value) {
            addCriterion("store_tel like", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotLike(String value) {
            addCriterion("store_tel not like", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelIn(List<String> values) {
            addCriterion("store_tel in", values, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotIn(List<String> values) {
            addCriterion("store_tel not in", values, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelBetween(String value1, String value2) {
            addCriterion("store_tel between", value1, value2, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotBetween(String value1, String value2) {
            addCriterion("store_tel not between", value1, value2, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidIsNull() {
            addCriterion("store_openid is null");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidIsNotNull() {
            addCriterion("store_openid is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidEqualTo(String value) {
            addCriterion("store_openid =", value, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidNotEqualTo(String value) {
            addCriterion("store_openid <>", value, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidGreaterThan(String value) {
            addCriterion("store_openid >", value, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("store_openid >=", value, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidLessThan(String value) {
            addCriterion("store_openid <", value, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidLessThanOrEqualTo(String value) {
            addCriterion("store_openid <=", value, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidLike(String value) {
            addCriterion("store_openid like", value, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidNotLike(String value) {
            addCriterion("store_openid not like", value, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidIn(List<String> values) {
            addCriterion("store_openid in", values, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidNotIn(List<String> values) {
            addCriterion("store_openid not in", values, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidBetween(String value1, String value2) {
            addCriterion("store_openid between", value1, value2, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreOpenidNotBetween(String value1, String value2) {
            addCriterion("store_openid not between", value1, value2, "storeOpenid");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureIsNull() {
            addCriterion("store_certificationPicture is null");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureIsNotNull() {
            addCriterion("store_certificationPicture is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureEqualTo(String value) {
            addCriterion("store_certificationPicture =", value, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureNotEqualTo(String value) {
            addCriterion("store_certificationPicture <>", value, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureGreaterThan(String value) {
            addCriterion("store_certificationPicture >", value, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureGreaterThanOrEqualTo(String value) {
            addCriterion("store_certificationPicture >=", value, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureLessThan(String value) {
            addCriterion("store_certificationPicture <", value, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureLessThanOrEqualTo(String value) {
            addCriterion("store_certificationPicture <=", value, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureLike(String value) {
            addCriterion("store_certificationPicture like", value, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureNotLike(String value) {
            addCriterion("store_certificationPicture not like", value, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureIn(List<String> values) {
            addCriterion("store_certificationPicture in", values, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureNotIn(List<String> values) {
            addCriterion("store_certificationPicture not in", values, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureBetween(String value1, String value2) {
            addCriterion("store_certificationPicture between", value1, value2, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreCertificationpictureNotBetween(String value1, String value2) {
            addCriterion("store_certificationPicture not between", value1, value2, "storeCertificationpicture");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeIsNull() {
            addCriterion("store_realNameType is null");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeIsNotNull() {
            addCriterion("store_realNameType is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeEqualTo(String value) {
            addCriterion("store_realNameType =", value, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeNotEqualTo(String value) {
            addCriterion("store_realNameType <>", value, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeGreaterThan(String value) {
            addCriterion("store_realNameType >", value, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeGreaterThanOrEqualTo(String value) {
            addCriterion("store_realNameType >=", value, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeLessThan(String value) {
            addCriterion("store_realNameType <", value, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeLessThanOrEqualTo(String value) {
            addCriterion("store_realNameType <=", value, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeLike(String value) {
            addCriterion("store_realNameType like", value, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeNotLike(String value) {
            addCriterion("store_realNameType not like", value, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeIn(List<String> values) {
            addCriterion("store_realNameType in", values, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeNotIn(List<String> values) {
            addCriterion("store_realNameType not in", values, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeBetween(String value1, String value2) {
            addCriterion("store_realNameType between", value1, value2, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreRealnametypeNotBetween(String value1, String value2) {
            addCriterion("store_realNameType not between", value1, value2, "storeRealnametype");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeIsNull() {
            addCriterion("store_addTime is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeIsNotNull() {
            addCriterion("store_addTime is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeEqualTo(String value) {
            addCriterion("store_addTime =", value, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeNotEqualTo(String value) {
            addCriterion("store_addTime <>", value, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeGreaterThan(String value) {
            addCriterion("store_addTime >", value, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("store_addTime >=", value, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeLessThan(String value) {
            addCriterion("store_addTime <", value, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeLessThanOrEqualTo(String value) {
            addCriterion("store_addTime <=", value, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeLike(String value) {
            addCriterion("store_addTime like", value, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeNotLike(String value) {
            addCriterion("store_addTime not like", value, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeIn(List<String> values) {
            addCriterion("store_addTime in", values, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeNotIn(List<String> values) {
            addCriterion("store_addTime not in", values, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeBetween(String value1, String value2) {
            addCriterion("store_addTime between", value1, value2, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andStoreAddtimeNotBetween(String value1, String value2) {
            addCriterion("store_addTime not between", value1, value2, "storeAddtime");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(String value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(String value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(String value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(String value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(String value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(String value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLike(String value) {
            addCriterion("balance like", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotLike(String value) {
            addCriterion("balance not like", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<String> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<String> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(String value1, String value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(String value1, String value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameIsNull() {
            addCriterion("store_NickName is null");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameIsNotNull() {
            addCriterion("store_NickName is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameEqualTo(String value) {
            addCriterion("store_NickName =", value, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameNotEqualTo(String value) {
            addCriterion("store_NickName <>", value, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameGreaterThan(String value) {
            addCriterion("store_NickName >", value, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("store_NickName >=", value, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameLessThan(String value) {
            addCriterion("store_NickName <", value, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameLessThanOrEqualTo(String value) {
            addCriterion("store_NickName <=", value, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameLike(String value) {
            addCriterion("store_NickName like", value, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameNotLike(String value) {
            addCriterion("store_NickName not like", value, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameIn(List<String> values) {
            addCriterion("store_NickName in", values, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameNotIn(List<String> values) {
            addCriterion("store_NickName not in", values, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameBetween(String value1, String value2) {
            addCriterion("store_NickName between", value1, value2, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStoreNicknameNotBetween(String value1, String value2) {
            addCriterion("store_NickName not between", value1, value2, "storeNickname");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteIsNull() {
            addCriterion("store_pickUpSite is null");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteIsNotNull() {
            addCriterion("store_pickUpSite is not null");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteEqualTo(String value) {
            addCriterion("store_pickUpSite =", value, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteNotEqualTo(String value) {
            addCriterion("store_pickUpSite <>", value, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteGreaterThan(String value) {
            addCriterion("store_pickUpSite >", value, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteGreaterThanOrEqualTo(String value) {
            addCriterion("store_pickUpSite >=", value, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteLessThan(String value) {
            addCriterion("store_pickUpSite <", value, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteLessThanOrEqualTo(String value) {
            addCriterion("store_pickUpSite <=", value, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteLike(String value) {
            addCriterion("store_pickUpSite like", value, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteNotLike(String value) {
            addCriterion("store_pickUpSite not like", value, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteIn(List<String> values) {
            addCriterion("store_pickUpSite in", values, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteNotIn(List<String> values) {
            addCriterion("store_pickUpSite not in", values, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteBetween(String value1, String value2) {
            addCriterion("store_pickUpSite between", value1, value2, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStorePickupsiteNotBetween(String value1, String value2) {
            addCriterion("store_pickUpSite not between", value1, value2, "storePickupsite");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailIsNull() {
            addCriterion("store_addressDetail is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailIsNotNull() {
            addCriterion("store_addressDetail is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailEqualTo(String value) {
            addCriterion("store_addressDetail =", value, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailNotEqualTo(String value) {
            addCriterion("store_addressDetail <>", value, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailGreaterThan(String value) {
            addCriterion("store_addressDetail >", value, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailGreaterThanOrEqualTo(String value) {
            addCriterion("store_addressDetail >=", value, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailLessThan(String value) {
            addCriterion("store_addressDetail <", value, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailLessThanOrEqualTo(String value) {
            addCriterion("store_addressDetail <=", value, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailLike(String value) {
            addCriterion("store_addressDetail like", value, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailNotLike(String value) {
            addCriterion("store_addressDetail not like", value, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailIn(List<String> values) {
            addCriterion("store_addressDetail in", values, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailNotIn(List<String> values) {
            addCriterion("store_addressDetail not in", values, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailBetween(String value1, String value2) {
            addCriterion("store_addressDetail between", value1, value2, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressdetailNotBetween(String value1, String value2) {
            addCriterion("store_addressDetail not between", value1, value2, "storeAddressdetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailIsNull() {
            addCriterion("store_pickUpSiteDetail is null");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailIsNotNull() {
            addCriterion("store_pickUpSiteDetail is not null");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailEqualTo(String value) {
            addCriterion("store_pickUpSiteDetail =", value, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailNotEqualTo(String value) {
            addCriterion("store_pickUpSiteDetail <>", value, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailGreaterThan(String value) {
            addCriterion("store_pickUpSiteDetail >", value, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailGreaterThanOrEqualTo(String value) {
            addCriterion("store_pickUpSiteDetail >=", value, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailLessThan(String value) {
            addCriterion("store_pickUpSiteDetail <", value, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailLessThanOrEqualTo(String value) {
            addCriterion("store_pickUpSiteDetail <=", value, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailLike(String value) {
            addCriterion("store_pickUpSiteDetail like", value, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailNotLike(String value) {
            addCriterion("store_pickUpSiteDetail not like", value, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailIn(List<String> values) {
            addCriterion("store_pickUpSiteDetail in", values, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailNotIn(List<String> values) {
            addCriterion("store_pickUpSiteDetail not in", values, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailBetween(String value1, String value2) {
            addCriterion("store_pickUpSiteDetail between", value1, value2, "storePickupsitedetail");
            return (Criteria) this;
        }

        public Criteria andStorePickupsitedetailNotBetween(String value1, String value2) {
            addCriterion("store_pickUpSiteDetail not between", value1, value2, "storePickupsitedetail");
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