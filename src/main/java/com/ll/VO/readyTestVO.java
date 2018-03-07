package com.ll.VO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class readyTestVO {
    private Integer id;
    private String studentPhone;
    private String studentProject;
    private String studentName;
    private String studentIdcard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentProject() {
        return studentProject;
    }

    public void setStudentProject(String studentProject) {
        this.studentProject = studentProject;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentIdcard() {
        return studentIdcard;
    }

    public void setStudentIdcard(String studentIdcard) {
        this.studentIdcard = studentIdcard;
    }
}
