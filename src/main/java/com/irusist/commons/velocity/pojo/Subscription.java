package com.irusist.commons.velocity.pojo;

import java.util.Date;

/**
 * description
 *
 * @author zhulixin
 */
public class Subscription {

    private Person customer;

    private Magazine magazine;

    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
}
