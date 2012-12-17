package com.irusist.commons.collections.pojo;

/**
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午2:45
 */
public class Team {
    private String name;

    private Person coach;

    public Team(String name, Person coach) {
        this.name = name;
        this.coach = coach;
    }

    public Person getCoach() {
        return coach;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
