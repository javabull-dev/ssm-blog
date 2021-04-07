package com.javabull.ssm.blog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OptionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OptionsExample() {
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

        public Criteria andOptionIdIsNull() {
            addCriterion("option_id is null");
            return (Criteria) this;
        }

        public Criteria andOptionIdIsNotNull() {
            addCriterion("option_id is not null");
            return (Criteria) this;
        }

        public Criteria andOptionIdEqualTo(Integer value) {
            addCriterion("option_id =", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotEqualTo(Integer value) {
            addCriterion("option_id <>", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdGreaterThan(Integer value) {
            addCriterion("option_id >", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("option_id >=", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLessThan(Integer value) {
            addCriterion("option_id <", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLessThanOrEqualTo(Integer value) {
            addCriterion("option_id <=", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdIn(List<Integer> values) {
            addCriterion("option_id in", values, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotIn(List<Integer> values) {
            addCriterion("option_id not in", values, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdBetween(Integer value1, Integer value2) {
            addCriterion("option_id between", value1, value2, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("option_id not between", value1, value2, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionTitleIsNull() {
            addCriterion("option_title is null");
            return (Criteria) this;
        }

        public Criteria andOptionTitleIsNotNull() {
            addCriterion("option_title is not null");
            return (Criteria) this;
        }

        public Criteria andOptionTitleEqualTo(String value) {
            addCriterion("option_title =", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleNotEqualTo(String value) {
            addCriterion("option_title <>", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleGreaterThan(String value) {
            addCriterion("option_title >", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("option_title >=", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleLessThan(String value) {
            addCriterion("option_title <", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleLessThanOrEqualTo(String value) {
            addCriterion("option_title <=", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleLike(String value) {
            addCriterion("option_title like", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleNotLike(String value) {
            addCriterion("option_title not like", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleIn(List<String> values) {
            addCriterion("option_title in", values, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleNotIn(List<String> values) {
            addCriterion("option_title not in", values, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleBetween(String value1, String value2) {
            addCriterion("option_title between", value1, value2, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleNotBetween(String value1, String value2) {
            addCriterion("option_title not between", value1, value2, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionIsNull() {
            addCriterion("option_site_descrption is null");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionIsNotNull() {
            addCriterion("option_site_descrption is not null");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionEqualTo(String value) {
            addCriterion("option_site_descrption =", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionNotEqualTo(String value) {
            addCriterion("option_site_descrption <>", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionGreaterThan(String value) {
            addCriterion("option_site_descrption >", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionGreaterThanOrEqualTo(String value) {
            addCriterion("option_site_descrption >=", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionLessThan(String value) {
            addCriterion("option_site_descrption <", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionLessThanOrEqualTo(String value) {
            addCriterion("option_site_descrption <=", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionLike(String value) {
            addCriterion("option_site_descrption like", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionNotLike(String value) {
            addCriterion("option_site_descrption not like", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionIn(List<String> values) {
            addCriterion("option_site_descrption in", values, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionNotIn(List<String> values) {
            addCriterion("option_site_descrption not in", values, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionBetween(String value1, String value2) {
            addCriterion("option_site_descrption between", value1, value2, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionNotBetween(String value1, String value2) {
            addCriterion("option_site_descrption not between", value1, value2, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionIsNull() {
            addCriterion("option_page_descrption is null");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionIsNotNull() {
            addCriterion("option_page_descrption is not null");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionEqualTo(String value) {
            addCriterion("option_page_descrption =", value, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionNotEqualTo(String value) {
            addCriterion("option_page_descrption <>", value, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionGreaterThan(String value) {
            addCriterion("option_page_descrption >", value, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionGreaterThanOrEqualTo(String value) {
            addCriterion("option_page_descrption >=", value, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionLessThan(String value) {
            addCriterion("option_page_descrption <", value, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionLessThanOrEqualTo(String value) {
            addCriterion("option_page_descrption <=", value, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionLike(String value) {
            addCriterion("option_page_descrption like", value, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionNotLike(String value) {
            addCriterion("option_page_descrption not like", value, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionIn(List<String> values) {
            addCriterion("option_page_descrption in", values, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionNotIn(List<String> values) {
            addCriterion("option_page_descrption not in", values, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionBetween(String value1, String value2) {
            addCriterion("option_page_descrption between", value1, value2, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionPageDescrptionNotBetween(String value1, String value2) {
            addCriterion("option_page_descrption not between", value1, value2, "optionPageDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordIsNull() {
            addCriterion("option_meta_keyword is null");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordIsNotNull() {
            addCriterion("option_meta_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordEqualTo(String value) {
            addCriterion("option_meta_keyword =", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordNotEqualTo(String value) {
            addCriterion("option_meta_keyword <>", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordGreaterThan(String value) {
            addCriterion("option_meta_keyword >", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("option_meta_keyword >=", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordLessThan(String value) {
            addCriterion("option_meta_keyword <", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordLessThanOrEqualTo(String value) {
            addCriterion("option_meta_keyword <=", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordLike(String value) {
            addCriterion("option_meta_keyword like", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordNotLike(String value) {
            addCriterion("option_meta_keyword not like", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordIn(List<String> values) {
            addCriterion("option_meta_keyword in", values, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordNotIn(List<String> values) {
            addCriterion("option_meta_keyword not in", values, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordBetween(String value1, String value2) {
            addCriterion("option_meta_keyword between", value1, value2, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordNotBetween(String value1, String value2) {
            addCriterion("option_meta_keyword not between", value1, value2, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeIsNull() {
            addCriterion("option_update_time is null");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeIsNotNull() {
            addCriterion("option_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeEqualTo(Date value) {
            addCriterion("option_update_time =", value, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeNotEqualTo(Date value) {
            addCriterion("option_update_time <>", value, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeGreaterThan(Date value) {
            addCriterion("option_update_time >", value, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("option_update_time >=", value, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeLessThan(Date value) {
            addCriterion("option_update_time <", value, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("option_update_time <=", value, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeIn(List<Date> values) {
            addCriterion("option_update_time in", values, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeNotIn(List<Date> values) {
            addCriterion("option_update_time not in", values, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("option_update_time between", value1, value2, "optionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOptionUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("option_update_time not between", value1, value2, "optionUpdateTime");
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