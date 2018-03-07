package com.ll.pojo;

import java.util.ArrayList;
import java.util.List;

public class SubjectTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectTimeExample() {
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

        public Criteria andTestNameIsNull() {
            addCriterion("test_name is null");
            return (Criteria) this;
        }

        public Criteria andTestNameIsNotNull() {
            addCriterion("test_name is not null");
            return (Criteria) this;
        }

        public Criteria andTestNameEqualTo(String value) {
            addCriterion("test_name =", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotEqualTo(String value) {
            addCriterion("test_name <>", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameGreaterThan(String value) {
            addCriterion("test_name >", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameGreaterThanOrEqualTo(String value) {
            addCriterion("test_name >=", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLessThan(String value) {
            addCriterion("test_name <", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLessThanOrEqualTo(String value) {
            addCriterion("test_name <=", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLike(String value) {
            addCriterion("test_name like", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotLike(String value) {
            addCriterion("test_name not like", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameIn(List<String> values) {
            addCriterion("test_name in", values, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotIn(List<String> values) {
            addCriterion("test_name not in", values, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameBetween(String value1, String value2) {
            addCriterion("test_name between", value1, value2, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotBetween(String value1, String value2) {
            addCriterion("test_name not between", value1, value2, "testName");
            return (Criteria) this;
        }

        public Criteria andTestTimeIsNull() {
            addCriterion("test_time is null");
            return (Criteria) this;
        }

        public Criteria andTestTimeIsNotNull() {
            addCriterion("test_time is not null");
            return (Criteria) this;
        }

        public Criteria andTestTimeEqualTo(String value) {
            addCriterion("test_time =", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotEqualTo(String value) {
            addCriterion("test_time <>", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeGreaterThan(String value) {
            addCriterion("test_time >", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeGreaterThanOrEqualTo(String value) {
            addCriterion("test_time >=", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeLessThan(String value) {
            addCriterion("test_time <", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeLessThanOrEqualTo(String value) {
            addCriterion("test_time <=", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeLike(String value) {
            addCriterion("test_time like", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotLike(String value) {
            addCriterion("test_time not like", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeIn(List<String> values) {
            addCriterion("test_time in", values, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotIn(List<String> values) {
            addCriterion("test_time not in", values, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeBetween(String value1, String value2) {
            addCriterion("test_time between", value1, value2, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotBetween(String value1, String value2) {
            addCriterion("test_time not between", value1, value2, "testTime");
            return (Criteria) this;
        }

        public Criteria andTrainerNameIsNull() {
            addCriterion("trainer_name is null");
            return (Criteria) this;
        }

        public Criteria andTrainerNameIsNotNull() {
            addCriterion("trainer_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerNameEqualTo(String value) {
            addCriterion("trainer_name =", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameNotEqualTo(String value) {
            addCriterion("trainer_name <>", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameGreaterThan(String value) {
            addCriterion("trainer_name >", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameGreaterThanOrEqualTo(String value) {
            addCriterion("trainer_name >=", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameLessThan(String value) {
            addCriterion("trainer_name <", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameLessThanOrEqualTo(String value) {
            addCriterion("trainer_name <=", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameLike(String value) {
            addCriterion("trainer_name like", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameNotLike(String value) {
            addCriterion("trainer_name not like", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameIn(List<String> values) {
            addCriterion("trainer_name in", values, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameNotIn(List<String> values) {
            addCriterion("trainer_name not in", values, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameBetween(String value1, String value2) {
            addCriterion("trainer_name between", value1, value2, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameNotBetween(String value1, String value2) {
            addCriterion("trainer_name not between", value1, value2, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamIsNull() {
            addCriterion("trainer_statusam is null");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamIsNotNull() {
            addCriterion("trainer_statusam is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamEqualTo(Integer value) {
            addCriterion("trainer_statusam =", value, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamNotEqualTo(Integer value) {
            addCriterion("trainer_statusam <>", value, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamGreaterThan(Integer value) {
            addCriterion("trainer_statusam >", value, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamGreaterThanOrEqualTo(Integer value) {
            addCriterion("trainer_statusam >=", value, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamLessThan(Integer value) {
            addCriterion("trainer_statusam <", value, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamLessThanOrEqualTo(Integer value) {
            addCriterion("trainer_statusam <=", value, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamIn(List<Integer> values) {
            addCriterion("trainer_statusam in", values, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamNotIn(List<Integer> values) {
            addCriterion("trainer_statusam not in", values, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamBetween(Integer value1, Integer value2) {
            addCriterion("trainer_statusam between", value1, value2, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatusamNotBetween(Integer value1, Integer value2) {
            addCriterion("trainer_statusam not between", value1, value2, "trainerStatusam");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmIsNull() {
            addCriterion("trainer_statuspm is null");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmIsNotNull() {
            addCriterion("trainer_statuspm is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmEqualTo(Integer value) {
            addCriterion("trainer_statuspm =", value, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmNotEqualTo(Integer value) {
            addCriterion("trainer_statuspm <>", value, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmGreaterThan(Integer value) {
            addCriterion("trainer_statuspm >", value, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmGreaterThanOrEqualTo(Integer value) {
            addCriterion("trainer_statuspm >=", value, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmLessThan(Integer value) {
            addCriterion("trainer_statuspm <", value, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmLessThanOrEqualTo(Integer value) {
            addCriterion("trainer_statuspm <=", value, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmIn(List<Integer> values) {
            addCriterion("trainer_statuspm in", values, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmNotIn(List<Integer> values) {
            addCriterion("trainer_statuspm not in", values, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmBetween(Integer value1, Integer value2) {
            addCriterion("trainer_statuspm between", value1, value2, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerStatuspmNotBetween(Integer value1, Integer value2) {
            addCriterion("trainer_statuspm not between", value1, value2, "trainerStatuspm");
            return (Criteria) this;
        }

        public Criteria andTrainerCountIsNull() {
            addCriterion("trainer_count is null");
            return (Criteria) this;
        }

        public Criteria andTrainerCountIsNotNull() {
            addCriterion("trainer_count is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerCountEqualTo(Integer value) {
            addCriterion("trainer_count =", value, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountNotEqualTo(Integer value) {
            addCriterion("trainer_count <>", value, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountGreaterThan(Integer value) {
            addCriterion("trainer_count >", value, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("trainer_count >=", value, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountLessThan(Integer value) {
            addCriterion("trainer_count <", value, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountLessThanOrEqualTo(Integer value) {
            addCriterion("trainer_count <=", value, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountIn(List<Integer> values) {
            addCriterion("trainer_count in", values, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountNotIn(List<Integer> values) {
            addCriterion("trainer_count not in", values, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountBetween(Integer value1, Integer value2) {
            addCriterion("trainer_count between", value1, value2, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerCountNotBetween(Integer value1, Integer value2) {
            addCriterion("trainer_count not between", value1, value2, "trainerCount");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursIsNull() {
            addCriterion("trainer_hours is null");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursIsNotNull() {
            addCriterion("trainer_hours is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursEqualTo(String value) {
            addCriterion("trainer_hours =", value, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursNotEqualTo(String value) {
            addCriterion("trainer_hours <>", value, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursGreaterThan(String value) {
            addCriterion("trainer_hours >", value, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursGreaterThanOrEqualTo(String value) {
            addCriterion("trainer_hours >=", value, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursLessThan(String value) {
            addCriterion("trainer_hours <", value, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursLessThanOrEqualTo(String value) {
            addCriterion("trainer_hours <=", value, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursLike(String value) {
            addCriterion("trainer_hours like", value, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursNotLike(String value) {
            addCriterion("trainer_hours not like", value, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursIn(List<String> values) {
            addCriterion("trainer_hours in", values, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursNotIn(List<String> values) {
            addCriterion("trainer_hours not in", values, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursBetween(String value1, String value2) {
            addCriterion("trainer_hours between", value1, value2, "trainerHours");
            return (Criteria) this;
        }

        public Criteria andTrainerHoursNotBetween(String value1, String value2) {
            addCriterion("trainer_hours not between", value1, value2, "trainerHours");
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