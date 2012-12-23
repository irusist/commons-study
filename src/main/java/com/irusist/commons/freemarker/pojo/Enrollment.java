package com.irusist.commons.freemarker.pojo;

import java.util.List;

/**
 * description
 *
 * @author zhulixin
 */
public class Enrollment {

    private Person student;

    private Course course;

    private List<Exam> exams;

    private int section;

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}
