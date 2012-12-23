package com.irusist.commons.freemarker.pojo;

import java.util.Date;

/**
 * description
 *
 * @author zhulixin
 */
public class Exam {

    private String name;

    private Date date;

    private float score;

    private float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
