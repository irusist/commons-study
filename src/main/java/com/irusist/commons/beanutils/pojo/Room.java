package com.irusist.commons.beanutils.pojo;

/**
 * User: zhulixin
 * Date: 12-11-30
 * Time: 上午11:22
 */
public class Room {

    private int area;

    private boolean carpeted;

    private boolean furnished;

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isCarpeted() {
        return carpeted;
    }

    public void setCarpeted(boolean carpeted) {
        this.carpeted = carpeted;
    }

    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }
}
