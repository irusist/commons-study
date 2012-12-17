package com.irusist.commons.beanutils.pojo;

import java.util.List;

/**
 * User: zhulixin
 * Date: 12-11-30
 * Time: 上午11:37
 */
public class Country {

    private String name;

    private List<Region> regions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
