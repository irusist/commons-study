package com.irusist.commons.collections.pojo;

import java.util.Date;

/**
 * User: zhulixin
 * Date: 12-12-10
 * Time: 上午11:02
 */
public class Patient {

    private String name;

    private Integer severity;

    private Date checkIn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }
}
