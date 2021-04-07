package com.javabull.ssm.blog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNull() {
            addCriterion("article_status is null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNotNull() {
            addCriterion("article_status is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusEqualTo(Integer value) {
            addCriterion("article_status =", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotEqualTo(Integer value) {
            addCriterion("article_status <>", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThan(Integer value) {
            addCriterion("article_status >", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_status >=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThan(Integer value) {
            addCriterion("article_status <", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("article_status <=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIn(List<Integer> values) {
            addCriterion("article_status in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotIn(List<Integer> values) {
            addCriterion("article_status not in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusBetween(Integer value1, Integer value2) {
            addCriterion("article_status between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("article_status not between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlIsNull() {
            addCriterion("article_image_url is null");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlIsNotNull() {
            addCriterion("article_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlEqualTo(String value) {
            addCriterion("article_image_url =", value, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlNotEqualTo(String value) {
            addCriterion("article_image_url <>", value, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlGreaterThan(String value) {
            addCriterion("article_image_url >", value, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("article_image_url >=", value, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlLessThan(String value) {
            addCriterion("article_image_url <", value, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlLessThanOrEqualTo(String value) {
            addCriterion("article_image_url <=", value, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlLike(String value) {
            addCriterion("article_image_url like", value, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlNotLike(String value) {
            addCriterion("article_image_url not like", value, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlIn(List<String> values) {
            addCriterion("article_image_url in", values, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlNotIn(List<String> values) {
            addCriterion("article_image_url not in", values, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlBetween(String value1, String value2) {
            addCriterion("article_image_url between", value1, value2, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleImageUrlNotBetween(String value1, String value2) {
            addCriterion("article_image_url not between", value1, value2, "articleImageUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeIsNull() {
            addCriterion("article_create_time is null");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeIsNotNull() {
            addCriterion("article_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeEqualTo(Date value) {
            addCriterion("article_create_time =", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeNotEqualTo(Date value) {
            addCriterion("article_create_time <>", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeGreaterThan(Date value) {
            addCriterion("article_create_time >", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_create_time >=", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeLessThan(Date value) {
            addCriterion("article_create_time <", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_create_time <=", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeIn(List<Date> values) {
            addCriterion("article_create_time in", values, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeNotIn(List<Date> values) {
            addCriterion("article_create_time not in", values, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeBetween(Date value1, Date value2) {
            addCriterion("article_create_time between", value1, value2, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_create_time not between", value1, value2, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIsNull() {
            addCriterion("article_update_time is null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIsNotNull() {
            addCriterion("article_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeEqualTo(Date value) {
            addCriterion("article_update_time =", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotEqualTo(Date value) {
            addCriterion("article_update_time <>", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeGreaterThan(Date value) {
            addCriterion("article_update_time >", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_update_time >=", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeLessThan(Date value) {
            addCriterion("article_update_time <", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_update_time <=", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIn(List<Date> values) {
            addCriterion("article_update_time in", values, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotIn(List<Date> values) {
            addCriterion("article_update_time not in", values, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("article_update_time between", value1, value2, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_update_time not between", value1, value2, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountIsNull() {
            addCriterion("article_read_amount is null");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountIsNotNull() {
            addCriterion("article_read_amount is not null");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountEqualTo(Integer value) {
            addCriterion("article_read_amount =", value, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountNotEqualTo(Integer value) {
            addCriterion("article_read_amount <>", value, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountGreaterThan(Integer value) {
            addCriterion("article_read_amount >", value, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_read_amount >=", value, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountLessThan(Integer value) {
            addCriterion("article_read_amount <", value, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountLessThanOrEqualTo(Integer value) {
            addCriterion("article_read_amount <=", value, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountIn(List<Integer> values) {
            addCriterion("article_read_amount in", values, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountNotIn(List<Integer> values) {
            addCriterion("article_read_amount not in", values, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountBetween(Integer value1, Integer value2) {
            addCriterion("article_read_amount between", value1, value2, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleReadAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("article_read_amount not between", value1, value2, "articleReadAmount");
            return (Criteria) this;
        }

        public Criteria andArticleOrderIsNull() {
            addCriterion("article_order is null");
            return (Criteria) this;
        }

        public Criteria andArticleOrderIsNotNull() {
            addCriterion("article_order is not null");
            return (Criteria) this;
        }

        public Criteria andArticleOrderEqualTo(Integer value) {
            addCriterion("article_order =", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderNotEqualTo(Integer value) {
            addCriterion("article_order <>", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderGreaterThan(Integer value) {
            addCriterion("article_order >", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_order >=", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderLessThan(Integer value) {
            addCriterion("article_order <", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderLessThanOrEqualTo(Integer value) {
            addCriterion("article_order <=", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderIn(List<Integer> values) {
            addCriterion("article_order in", values, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderNotIn(List<Integer> values) {
            addCriterion("article_order not in", values, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderBetween(Integer value1, Integer value2) {
            addCriterion("article_order between", value1, value2, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("article_order not between", value1, value2, "articleOrder");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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