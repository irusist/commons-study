package com.irusist.commons.beanutils.pojo;

/**
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午3:23
 */
public class Coach {

    private String firstName;

    private String lastName;

    public Coach(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
