package com.yczc.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class ContestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContestExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPteamidIsNull() {
            addCriterion("pteamid is null");
            return (Criteria) this;
        }

        public Criteria andPteamidIsNotNull() {
            addCriterion("pteamid is not null");
            return (Criteria) this;
        }

        public Criteria andPteamidEqualTo(String value) {
            addCriterion("pteamid =", value, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidNotEqualTo(String value) {
            addCriterion("pteamid <>", value, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidGreaterThan(String value) {
            addCriterion("pteamid >", value, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidGreaterThanOrEqualTo(String value) {
            addCriterion("pteamid >=", value, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidLessThan(String value) {
            addCriterion("pteamid <", value, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidLessThanOrEqualTo(String value) {
            addCriterion("pteamid <=", value, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidLike(String value) {
            addCriterion("pteamid like", value, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidNotLike(String value) {
            addCriterion("pteamid not like", value, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidIn(List<String> values) {
            addCriterion("pteamid in", values, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidNotIn(List<String> values) {
            addCriterion("pteamid not in", values, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidBetween(String value1, String value2) {
            addCriterion("pteamid between", value1, value2, "pteamid");
            return (Criteria) this;
        }

        public Criteria andPteamidNotBetween(String value1, String value2) {
            addCriterion("pteamid not between", value1, value2, "pteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidIsNull() {
            addCriterion("mteamid is null");
            return (Criteria) this;
        }

        public Criteria andMteamidIsNotNull() {
            addCriterion("mteamid is not null");
            return (Criteria) this;
        }

        public Criteria andMteamidEqualTo(String value) {
            addCriterion("mteamid =", value, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidNotEqualTo(String value) {
            addCriterion("mteamid <>", value, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidGreaterThan(String value) {
            addCriterion("mteamid >", value, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidGreaterThanOrEqualTo(String value) {
            addCriterion("mteamid >=", value, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidLessThan(String value) {
            addCriterion("mteamid <", value, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidLessThanOrEqualTo(String value) {
            addCriterion("mteamid <=", value, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidLike(String value) {
            addCriterion("mteamid like", value, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidNotLike(String value) {
            addCriterion("mteamid not like", value, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidIn(List<String> values) {
            addCriterion("mteamid in", values, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidNotIn(List<String> values) {
            addCriterion("mteamid not in", values, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidBetween(String value1, String value2) {
            addCriterion("mteamid between", value1, value2, "mteamid");
            return (Criteria) this;
        }

        public Criteria andMteamidNotBetween(String value1, String value2) {
            addCriterion("mteamid not between", value1, value2, "mteamid");
            return (Criteria) this;
        }

        public Criteria andPopenidIsNull() {
            addCriterion("popenid is null");
            return (Criteria) this;
        }

        public Criteria andPopenidIsNotNull() {
            addCriterion("popenid is not null");
            return (Criteria) this;
        }

        public Criteria andPopenidEqualTo(String value) {
            addCriterion("popenid =", value, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidNotEqualTo(String value) {
            addCriterion("popenid <>", value, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidGreaterThan(String value) {
            addCriterion("popenid >", value, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidGreaterThanOrEqualTo(String value) {
            addCriterion("popenid >=", value, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidLessThan(String value) {
            addCriterion("popenid <", value, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidLessThanOrEqualTo(String value) {
            addCriterion("popenid <=", value, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidLike(String value) {
            addCriterion("popenid like", value, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidNotLike(String value) {
            addCriterion("popenid not like", value, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidIn(List<String> values) {
            addCriterion("popenid in", values, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidNotIn(List<String> values) {
            addCriterion("popenid not in", values, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidBetween(String value1, String value2) {
            addCriterion("popenid between", value1, value2, "popenid");
            return (Criteria) this;
        }

        public Criteria andPopenidNotBetween(String value1, String value2) {
            addCriterion("popenid not between", value1, value2, "popenid");
            return (Criteria) this;
        }

        public Criteria andMopenidIsNull() {
            addCriterion("mopenid is null");
            return (Criteria) this;
        }

        public Criteria andMopenidIsNotNull() {
            addCriterion("mopenid is not null");
            return (Criteria) this;
        }

        public Criteria andMopenidEqualTo(String value) {
            addCriterion("mopenid =", value, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidNotEqualTo(String value) {
            addCriterion("mopenid <>", value, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidGreaterThan(String value) {
            addCriterion("mopenid >", value, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidGreaterThanOrEqualTo(String value) {
            addCriterion("mopenid >=", value, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidLessThan(String value) {
            addCriterion("mopenid <", value, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidLessThanOrEqualTo(String value) {
            addCriterion("mopenid <=", value, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidLike(String value) {
            addCriterion("mopenid like", value, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidNotLike(String value) {
            addCriterion("mopenid not like", value, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidIn(List<String> values) {
            addCriterion("mopenid in", values, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidNotIn(List<String> values) {
            addCriterion("mopenid not in", values, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidBetween(String value1, String value2) {
            addCriterion("mopenid between", value1, value2, "mopenid");
            return (Criteria) this;
        }

        public Criteria andMopenidNotBetween(String value1, String value2) {
            addCriterion("mopenid not between", value1, value2, "mopenid");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("week like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("week not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andPostdateIsNull() {
            addCriterion("postdate is null");
            return (Criteria) this;
        }

        public Criteria andPostdateIsNotNull() {
            addCriterion("postdate is not null");
            return (Criteria) this;
        }

        public Criteria andPostdateEqualTo(String value) {
            addCriterion("postdate =", value, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateNotEqualTo(String value) {
            addCriterion("postdate <>", value, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateGreaterThan(String value) {
            addCriterion("postdate >", value, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateGreaterThanOrEqualTo(String value) {
            addCriterion("postdate >=", value, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateLessThan(String value) {
            addCriterion("postdate <", value, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateLessThanOrEqualTo(String value) {
            addCriterion("postdate <=", value, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateLike(String value) {
            addCriterion("postdate like", value, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateNotLike(String value) {
            addCriterion("postdate not like", value, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateIn(List<String> values) {
            addCriterion("postdate in", values, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateNotIn(List<String> values) {
            addCriterion("postdate not in", values, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateBetween(String value1, String value2) {
            addCriterion("postdate between", value1, value2, "postdate");
            return (Criteria) this;
        }

        public Criteria andPostdateNotBetween(String value1, String value2) {
            addCriterion("postdate not between", value1, value2, "postdate");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andAdressIsNull() {
            addCriterion("adress is null");
            return (Criteria) this;
        }

        public Criteria andAdressIsNotNull() {
            addCriterion("adress is not null");
            return (Criteria) this;
        }

        public Criteria andAdressEqualTo(String value) {
            addCriterion("adress =", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotEqualTo(String value) {
            addCriterion("adress <>", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThan(String value) {
            addCriterion("adress >", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThanOrEqualTo(String value) {
            addCriterion("adress >=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThan(String value) {
            addCriterion("adress <", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThanOrEqualTo(String value) {
            addCriterion("adress <=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLike(String value) {
            addCriterion("adress like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotLike(String value) {
            addCriterion("adress not like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressIn(List<String> values) {
            addCriterion("adress in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotIn(List<String> values) {
            addCriterion("adress not in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressBetween(String value1, String value2) {
            addCriterion("adress between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotBetween(String value1, String value2) {
            addCriterion("adress not between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andPersonIsNull() {
            addCriterion("person is null");
            return (Criteria) this;
        }

        public Criteria andPersonIsNotNull() {
            addCriterion("person is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEqualTo(Integer value) {
            addCriterion("person =", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotEqualTo(Integer value) {
            addCriterion("person <>", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThan(Integer value) {
            addCriterion("person >", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("person >=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThan(Integer value) {
            addCriterion("person <", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThanOrEqualTo(Integer value) {
            addCriterion("person <=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonIn(List<Integer> values) {
            addCriterion("person in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotIn(List<Integer> values) {
            addCriterion("person not in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonBetween(Integer value1, Integer value2) {
            addCriterion("person between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotBetween(Integer value1, Integer value2) {
            addCriterion("person not between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andClothingIsNull() {
            addCriterion("clothing is null");
            return (Criteria) this;
        }

        public Criteria andClothingIsNotNull() {
            addCriterion("clothing is not null");
            return (Criteria) this;
        }

        public Criteria andClothingEqualTo(String value) {
            addCriterion("clothing =", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingNotEqualTo(String value) {
            addCriterion("clothing <>", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingGreaterThan(String value) {
            addCriterion("clothing >", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingGreaterThanOrEqualTo(String value) {
            addCriterion("clothing >=", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingLessThan(String value) {
            addCriterion("clothing <", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingLessThanOrEqualTo(String value) {
            addCriterion("clothing <=", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingLike(String value) {
            addCriterion("clothing like", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingNotLike(String value) {
            addCriterion("clothing not like", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingIn(List<String> values) {
            addCriterion("clothing in", values, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingNotIn(List<String> values) {
            addCriterion("clothing not in", values, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingBetween(String value1, String value2) {
            addCriterion("clothing between", value1, value2, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingNotBetween(String value1, String value2) {
            addCriterion("clothing not between", value1, value2, "clothing");
            return (Criteria) this;
        }

        public Criteria andTurfIsNull() {
            addCriterion("turf is null");
            return (Criteria) this;
        }

        public Criteria andTurfIsNotNull() {
            addCriterion("turf is not null");
            return (Criteria) this;
        }

        public Criteria andTurfEqualTo(String value) {
            addCriterion("turf =", value, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfNotEqualTo(String value) {
            addCriterion("turf <>", value, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfGreaterThan(String value) {
            addCriterion("turf >", value, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfGreaterThanOrEqualTo(String value) {
            addCriterion("turf >=", value, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfLessThan(String value) {
            addCriterion("turf <", value, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfLessThanOrEqualTo(String value) {
            addCriterion("turf <=", value, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfLike(String value) {
            addCriterion("turf like", value, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfNotLike(String value) {
            addCriterion("turf not like", value, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfIn(List<String> values) {
            addCriterion("turf in", values, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfNotIn(List<String> values) {
            addCriterion("turf not in", values, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfBetween(String value1, String value2) {
            addCriterion("turf between", value1, value2, "turf");
            return (Criteria) this;
        }

        public Criteria andTurfNotBetween(String value1, String value2) {
            addCriterion("turf not between", value1, value2, "turf");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(String value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(String value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(String value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(String value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(String value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(String value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLike(String value) {
            addCriterion("cost like", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotLike(String value) {
            addCriterion("cost not like", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<String> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<String> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(String value1, String value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(String value1, String value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andEnsureIsNull() {
            addCriterion("ensure is null");
            return (Criteria) this;
        }

        public Criteria andEnsureIsNotNull() {
            addCriterion("ensure is not null");
            return (Criteria) this;
        }

        public Criteria andEnsureEqualTo(Integer value) {
            addCriterion("ensure =", value, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureNotEqualTo(Integer value) {
            addCriterion("ensure <>", value, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureGreaterThan(Integer value) {
            addCriterion("ensure >", value, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureGreaterThanOrEqualTo(Integer value) {
            addCriterion("ensure >=", value, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureLessThan(Integer value) {
            addCriterion("ensure <", value, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureLessThanOrEqualTo(Integer value) {
            addCriterion("ensure <=", value, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureIn(List<Integer> values) {
            addCriterion("ensure in", values, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureNotIn(List<Integer> values) {
            addCriterion("ensure not in", values, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureBetween(Integer value1, Integer value2) {
            addCriterion("ensure between", value1, value2, "ensure");
            return (Criteria) this;
        }

        public Criteria andEnsureNotBetween(Integer value1, Integer value2) {
            addCriterion("ensure not between", value1, value2, "ensure");
            return (Criteria) this;
        }

        public Criteria andAwardIsNull() {
            addCriterion("award is null");
            return (Criteria) this;
        }

        public Criteria andAwardIsNotNull() {
            addCriterion("award is not null");
            return (Criteria) this;
        }

        public Criteria andAwardEqualTo(Integer value) {
            addCriterion("award =", value, "award");
            return (Criteria) this;
        }

        public Criteria andAwardNotEqualTo(Integer value) {
            addCriterion("award <>", value, "award");
            return (Criteria) this;
        }

        public Criteria andAwardGreaterThan(Integer value) {
            addCriterion("award >", value, "award");
            return (Criteria) this;
        }

        public Criteria andAwardGreaterThanOrEqualTo(Integer value) {
            addCriterion("award >=", value, "award");
            return (Criteria) this;
        }

        public Criteria andAwardLessThan(Integer value) {
            addCriterion("award <", value, "award");
            return (Criteria) this;
        }

        public Criteria andAwardLessThanOrEqualTo(Integer value) {
            addCriterion("award <=", value, "award");
            return (Criteria) this;
        }

        public Criteria andAwardIn(List<Integer> values) {
            addCriterion("award in", values, "award");
            return (Criteria) this;
        }

        public Criteria andAwardNotIn(List<Integer> values) {
            addCriterion("award not in", values, "award");
            return (Criteria) this;
        }

        public Criteria andAwardBetween(Integer value1, Integer value2) {
            addCriterion("award between", value1, value2, "award");
            return (Criteria) this;
        }

        public Criteria andAwardNotBetween(Integer value1, Integer value2) {
            addCriterion("award not between", value1, value2, "award");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andReasonsIsNull() {
            addCriterion("reasons is null");
            return (Criteria) this;
        }

        public Criteria andReasonsIsNotNull() {
            addCriterion("reasons is not null");
            return (Criteria) this;
        }

        public Criteria andReasonsEqualTo(String value) {
            addCriterion("reasons =", value, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsNotEqualTo(String value) {
            addCriterion("reasons <>", value, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsGreaterThan(String value) {
            addCriterion("reasons >", value, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsGreaterThanOrEqualTo(String value) {
            addCriterion("reasons >=", value, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsLessThan(String value) {
            addCriterion("reasons <", value, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsLessThanOrEqualTo(String value) {
            addCriterion("reasons <=", value, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsLike(String value) {
            addCriterion("reasons like", value, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsNotLike(String value) {
            addCriterion("reasons not like", value, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsIn(List<String> values) {
            addCriterion("reasons in", values, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsNotIn(List<String> values) {
            addCriterion("reasons not in", values, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsBetween(String value1, String value2) {
            addCriterion("reasons between", value1, value2, "reasons");
            return (Criteria) this;
        }

        public Criteria andReasonsNotBetween(String value1, String value2) {
            addCriterion("reasons not between", value1, value2, "reasons");
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