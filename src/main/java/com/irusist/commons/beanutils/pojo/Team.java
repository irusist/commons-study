package com.irusist.commons.beanutils.pojo;

/**
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午3:23
 */
public class Team {

    private String name;

    private Coach coach;

    public Team(String name, Coach coach) {
        this.name = name;
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
