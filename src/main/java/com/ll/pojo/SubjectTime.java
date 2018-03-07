package com.ll.pojo;

public class SubjectTime {
    private Integer id;

    private String testName;

    private String testTime;

    private String trainerName;

    private Integer trainerStatusam;

    private Integer trainerStatuspm;

    private Integer trainerCount = 10;

    private String trainerHours = "06,07,08,09,10,14,15,16,17,18";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime == null ? null : testTime.trim();
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName == null ? null : trainerName.trim();
    }

    public Integer getTrainerStatusam() {
        return trainerStatusam;
    }

    public void setTrainerStatusam(Integer trainerStatusam) {
        this.trainerStatusam = trainerStatusam;
    }

    public Integer getTrainerStatuspm() {
        return trainerStatuspm;
    }

    public void setTrainerStatuspm(Integer trainerStatuspm) {
        this.trainerStatuspm = trainerStatuspm;
    }

    public Integer getTrainerCount() {
        return trainerCount;
    }

    public void setTrainerCount(Integer trainerCount) {
        this.trainerCount = trainerCount;
    }

    public String getTrainerHours() {
        return trainerHours;
    }

    public void setTrainerHours(String trainerHours) {
        this.trainerHours = trainerHours == null ? null : trainerHours.trim();
    }
}