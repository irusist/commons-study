package com.irusist.commons.xml.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author zhulixin
 */
public class Page {

    private String type;

    private String summary;

    private List<Person> persons = new ArrayList<Person>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
