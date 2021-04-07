package com.javabull.ssm.blog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScreenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScreenExample() {
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

        public Criteria andScreenIdIsNull() {
            addCriterion("screen_id is null");
            return (Criteria) this;
        }

        public Criteria andScreenIdIsNotNull() {
            addCriterion("screen_id is not null");
            return (Criteria) this;
        }

        public Criteria andScreenIdEqualTo(Integer value) {
            addCriterion("screen_id =", value, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdNotEqualTo(Integer value) {
            addCriterion("screen_id <>", value, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdGreaterThan(Integer value) {
            addCriterion("screen_id >", value, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("screen_id >=", value, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdLessThan(Integer value) {
            addCriterion("screen_id <", value, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdLessThanOrEqualTo(Integer value) {
            addCriterion("screen_id <=", value, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdIn(List<Integer> values) {
            addCriterion("screen_id in", values, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdNotIn(List<Integer> values) {
            addCriterion("screen_id not in", values, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdBetween(Integer value1, Integer value2) {
            addCriterion("screen_id between", value1, value2, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenIdNotBetween(Integer value1, Integer value2) {
            addCriterion("screen_id not between", value1, value2, "screenId");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameIsNull() {
            addCriterion("screen_img_name is null");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameIsNotNull() {
            addCriterion("screen_img_name is not null");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameEqualTo(String value) {
            addCriterion("screen_img_name =", value, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameNotEqualTo(String value) {
            addCriterion("screen_img_name <>", value, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameGreaterThan(String value) {
            addCriterion("screen_img_name >", value, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameGreaterThanOrEqualTo(String value) {
            addCriterion("screen_img_name >=", value, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameLessThan(String value) {
            addCriterion("screen_img_name <", value, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameLessThanOrEqualTo(String value) {
            addCriterion("screen_img_name <=", value, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameLike(String value) {
            addCriterion("screen_img_name like", value, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameNotLike(String value) {
            addCriterion("screen_img_name not like", value, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameIn(List<String> values) {
            addCriterion("screen_img_name in", values, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameNotIn(List<String> values) {
            addCriterion("screen_img_name not in", values, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameBetween(String value1, String value2) {
            addCriterion("screen_img_name between", value1, value2, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgNameNotBetween(String value1, String value2) {
            addCriterion("screen_img_name not between", value1, value2, "screenImgName");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlIsNull() {
            addCriterion("screen_img_url is null");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlIsNotNull() {
            addCriterion("screen_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlEqualTo(String value) {
            addCriterion("screen_img_url =", value, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlNotEqualTo(String value) {
            addCriterion("screen_img_url <>", value, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlGreaterThan(String value) {
            addCriterion("screen_img_url >", value, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("screen_img_url >=", value, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlLessThan(String value) {
            addCriterion("screen_img_url <", value, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlLessThanOrEqualTo(String value) {
            addCriterion("screen_img_url <=", value, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlLike(String value) {
            addCriterion("screen_img_url like", value, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlNotLike(String value) {
            addCriterion("screen_img_url not like", value, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlIn(List<String> values) {
            addCriterion("screen_img_url in", values, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlNotIn(List<String> values) {
            addCriterion("screen_img_url not in", values, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlBetween(String value1, String value2) {
            addCriterion("screen_img_url between", value1, value2, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenImgUrlNotBetween(String value1, String value2) {
            addCriterion("screen_img_url not between", value1, value2, "screenImgUrl");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeIsNull() {
            addCriterion("screen_create_time is null");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeIsNotNull() {
            addCriterion("screen_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeEqualTo(Date value) {
            addCriterion("screen_create_time =", value, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeNotEqualTo(Date value) {
            addCriterion("screen_create_time <>", value, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeGreaterThan(Date value) {
            addCriterion("screen_create_time >", value, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("screen_create_time >=", value, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeLessThan(Date value) {
            addCriterion("screen_create_time <", value, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("screen_create_time <=", value, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeIn(List<Date> values) {
            addCriterion("screen_create_time in", values, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeNotIn(List<Date> values) {
            addCriterion("screen_create_time not in", values, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeBetween(Date value1, Date value2) {
            addCriterion("screen_create_time between", value1, value2, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("screen_create_time not between", value1, value2, "screenCreateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeIsNull() {
            addCriterion("screen_update_time is null");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeIsNotNull() {
            addCriterion("screen_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeEqualTo(Date value) {
            addCriterion("screen_update_time =", value, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeNotEqualTo(Date value) {
            addCriterion("screen_update_time <>", value, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeGreaterThan(Date value) {
            addCriterion("screen_update_time >", value, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("screen_update_time >=", value, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeLessThan(Date value) {
            addCriterion("screen_update_time <", value, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("screen_update_time <=", value, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeIn(List<Date> values) {
            addCriterion("screen_update_time in", values, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeNotIn(List<Date> values) {
            addCriterion("screen_update_time not in", values, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("screen_update_time between", value1, value2, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("screen_update_time not between", value1, value2, "screenUpdateTime");
            return (Criteria) this;
        }

        public Criteria andScreenStatusIsNull() {
            addCriterion("screen_status is null");
            return (Criteria) this;
        }

        public Criteria andScreenStatusIsNotNull() {
            addCriterion("screen_status is not null");
            return (Criteria) this;
        }

        public Criteria andScreenStatusEqualTo(Integer value) {
            addCriterion("screen_status =", value, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusNotEqualTo(Integer value) {
            addCriterion("screen_status <>", value, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusGreaterThan(Integer value) {
            addCriterion("screen_status >", value, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("screen_status >=", value, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusLessThan(Integer value) {
            addCriterion("screen_status <", value, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusLessThanOrEqualTo(Integer value) {
            addCriterion("screen_status <=", value, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusIn(List<Integer> values) {
            addCriterion("screen_status in", values, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusNotIn(List<Integer> values) {
            addCriterion("screen_status not in", values, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusBetween(Integer value1, Integer value2) {
            addCriterion("screen_status between", value1, value2, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("screen_status not between", value1, value2, "screenStatus");
            return (Criteria) this;
        }

        public Criteria andScreenOrderIsNull() {
            addCriterion("screen_order is null");
            return (Criteria) this;
        }

        public Criteria andScreenOrderIsNotNull() {
            addCriterion("screen_order is not null");
            return (Criteria) this;
        }

        public Criteria andScreenOrderEqualTo(Integer value) {
            addCriterion("screen_order =", value, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderNotEqualTo(Integer value) {
            addCriterion("screen_order <>", value, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderGreaterThan(Integer value) {
            addCriterion("screen_order >", value, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("screen_order >=", value, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderLessThan(Integer value) {
            addCriterion("screen_order <", value, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderLessThanOrEqualTo(Integer value) {
            addCriterion("screen_order <=", value, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderIn(List<Integer> values) {
            addCriterion("screen_order in", values, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderNotIn(List<Integer> values) {
            addCriterion("screen_order not in", values, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderBetween(Integer value1, Integer value2) {
            addCriterion("screen_order between", value1, value2, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andScreenOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("screen_order not between", value1, value2, "screenOrder");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
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