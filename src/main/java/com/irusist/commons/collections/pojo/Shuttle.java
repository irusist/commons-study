package com.irusist.commons.collections.pojo;

/**
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午6:20
 */
public class Shuttle {

    private double fuelPercent;

    private boolean shieldingReady;

    private String name;

    public double getFuelPercent() {
        return fuelPercent;
    }

    public void setFuelPercent(double fuelPercent) {
        this.fuelPercent = fuelPercent;
    }

    public boolean isShieldingReady() {
        return shieldingReady;
    }

    public void setShieldingReady(boolean shieldingReady) {
        this.shieldingReady = shieldingReady;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
