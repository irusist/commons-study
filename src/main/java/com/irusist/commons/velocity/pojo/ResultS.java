package com.irusist.commons.velocity.pojo;

import java.util.List;

/**
 * description
 *
 * @author zhulixin
 */
public class ResultS {

    private int[] scores;

    private List<Student> students;

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
