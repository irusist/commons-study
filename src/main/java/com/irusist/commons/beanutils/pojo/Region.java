package com.irusist.commons.beanutils.pojo;

import java.util.Map;

/**
 * User: zhulixin
 * Date: 12-11-30
 * Time: 上午11:33
 */
public class Region {

    private String name;

    private Map<String, City> cities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, City> getCities() {
        return cities;
    }

    public void setCities(Map<String, City> cities) {
        this.cities = cities;
    }
}
