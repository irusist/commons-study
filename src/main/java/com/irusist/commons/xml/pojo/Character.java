package com.irusist.commons.xml.pojo;

/**
 * description
 *
 * @author zhulixin
 */
public class Character {

    private String name;

    private String description;

    private boolean protagonist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProtagonist() {
        return protagonist;
    }

    public void setProtagonist(boolean protagonist) {
        this.protagonist = protagonist;
    }
}
