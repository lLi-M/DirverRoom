package com.ll.pojo;

import java.util.ArrayList;
import java.util.List;

public class AppointmentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public AppointmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
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

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
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

        public Criteria andAppointmentTimeIsNull() {
            addCriterion("appointment_time is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIsNotNull() {
            addCriterion("appointment_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeEqualTo(String value) {
            addCriterion("appointment_time =", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotEqualTo(String value) {
            addCriterion("appointment_time <>", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThan(String value) {
            addCriterion("appointment_time >", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_time >=", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThan(String value) {
            addCriterion("appointment_time <", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThanOrEqualTo(String value) {
            addCriterion("appointment_time <=", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLike(String value) {
            addCriterion("appointment_time like", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotLike(String value) {
            addCriterion("appointment_time not like", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIn(List<String> values) {
            addCriterion("appointment_time in", values, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotIn(List<String> values) {
            addCriterion("appointment_time not in", values, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeBetween(String value1, String value2) {
            addCriterion("appointment_time between", value1, value2, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotBetween(String value1, String value2) {
            addCriterion("appointment_time not between", value1, value2, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardIsNull() {
            addCriterion("student_idCard is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardIsNotNull() {
            addCriterion("student_idCard is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardEqualTo(String value) {
            addCriterion("student_idCard =", value, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardNotEqualTo(String value) {
            addCriterion("student_idCard <>", value, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardGreaterThan(String value) {
            addCriterion("student_idCard >", value, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("student_idCard >=", value, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardLessThan(String value) {
            addCriterion("student_idCard <", value, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardLessThanOrEqualTo(String value) {
            addCriterion("student_idCard <=", value, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardLike(String value) {
            addCriterion("student_idCard like", value, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardNotLike(String value) {
            addCriterion("student_idCard not like", value, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardIn(List<String> values) {
            addCriterion("student_idCard in", values, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardNotIn(List<String> values) {
            addCriterion("student_idCard not in", values, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardBetween(String value1, String value2) {
            addCriterion("student_idCard between", value1, value2, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andStudentIdcardNotBetween(String value1, String value2) {
            addCriterion("student_idCard not between", value1, value2, "studentIdcard");
            return (Criteria) this;
        }

        public Criteria andAppointmentApIsNull() {
            addCriterion("appointment_ap is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentApIsNotNull() {
            addCriterion("appointment_ap is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentApEqualTo(String value) {
            addCriterion("appointment_ap =", value, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApNotEqualTo(String value) {
            addCriterion("appointment_ap <>", value, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApGreaterThan(String value) {
            addCriterion("appointment_ap >", value, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_ap >=", value, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApLessThan(String value) {
            addCriterion("appointment_ap <", value, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApLessThanOrEqualTo(String value) {
            addCriterion("appointment_ap <=", value, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApLike(String value) {
            addCriterion("appointment_ap like", value, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApNotLike(String value) {
            addCriterion("appointment_ap not like", value, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApIn(List<String> values) {
            addCriterion("appointment_ap in", values, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApNotIn(List<String> values) {
            addCriterion("appointment_ap not in", values, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApBetween(String value1, String value2) {
            addCriterion("appointment_ap between", value1, value2, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andAppointmentApNotBetween(String value1, String value2) {
            addCriterion("appointment_ap not between", value1, value2, "appointmentAp");
            return (Criteria) this;
        }

        public Criteria andTestSubjectIsNull() {
            addCriterion("test_subject is null");
            return (Criteria) this;
        }

        public Criteria andTestSubjectIsNotNull() {
            addCriterion("test_subject is not null");
            return (Criteria) this;
        }

        public Criteria andTestSubjectEqualTo(String value) {
            addCriterion("test_subject =", value, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectNotEqualTo(String value) {
            addCriterion("test_subject <>", value, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectGreaterThan(String value) {
            addCriterion("test_subject >", value, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("test_subject >=", value, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectLessThan(String value) {
            addCriterion("test_subject <", value, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectLessThanOrEqualTo(String value) {
            addCriterion("test_subject <=", value, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectLike(String value) {
            addCriterion("test_subject like", value, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectNotLike(String value) {
            addCriterion("test_subject not like", value, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectIn(List<String> values) {
            addCriterion("test_subject in", values, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectNotIn(List<String> values) {
            addCriterion("test_subject not in", values, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectBetween(String value1, String value2) {
            addCriterion("test_subject between", value1, value2, "testSubject");
            return (Criteria) this;
        }

        public Criteria andTestSubjectNotBetween(String value1, String value2) {
            addCriterion("test_subject not between", value1, value2, "testSubject");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIsNull() {
            addCriterion("student_phone is null");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIsNotNull() {
            addCriterion("student_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneEqualTo(String value) {
            addCriterion("student_phone =", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotEqualTo(String value) {
            addCriterion("student_phone <>", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneGreaterThan(String value) {
            addCriterion("student_phone >", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("student_phone >=", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLessThan(String value) {
            addCriterion("student_phone <", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLessThanOrEqualTo(String value) {
            addCriterion("student_phone <=", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLike(String value) {
            addCriterion("student_phone like", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotLike(String value) {
            addCriterion("student_phone not like", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIn(List<String> values) {
            addCriterion("student_phone in", values, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotIn(List<String> values) {
            addCriterion("student_phone not in", values, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneBetween(String value1, String value2) {
            addCriterion("student_phone between", value1, value2, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotBetween(String value1, String value2) {
            addCriterion("student_phone not between", value1, value2, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeIsNull() {
            addCriterion("appointment_clicktime is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeIsNotNull() {
            addCriterion("appointment_clicktime is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeEqualTo(String value) {
            addCriterion("appointment_clicktime =", value, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeNotEqualTo(String value) {
            addCriterion("appointment_clicktime <>", value, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeGreaterThan(String value) {
            addCriterion("appointment_clicktime >", value, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_clicktime >=", value, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeLessThan(String value) {
            addCriterion("appointment_clicktime <", value, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeLessThanOrEqualTo(String value) {
            addCriterion("appointment_clicktime <=", value, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeLike(String value) {
            addCriterion("appointment_clicktime like", value, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeNotLike(String value) {
            addCriterion("appointment_clicktime not like", value, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeIn(List<String> values) {
            addCriterion("appointment_clicktime in", values, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeNotIn(List<String> values) {
            addCriterion("appointment_clicktime not in", values, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeBetween(String value1, String value2) {
            addCriterion("appointment_clicktime between", value1, value2, "appointmentClicktime");
            return (Criteria) this;
        }

        public Criteria andAppointmentClicktimeNotBetween(String value1, String value2) {
            addCriterion("appointment_clicktime not between", value1, value2, "appointmentClicktime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table appointment
     *
     * @mbg.generated do_not_delete_during_merge Fri Dec 22 10:22:42 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table appointment
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
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