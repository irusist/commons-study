package com.irusist.commons.collections.pojo;

import java.util.Date;

/**
 * User: zhulixin
 * Date: 12-12-5
 * Time: 下午4:25
 */
public class EarthQuake {

    private String location;

    private Float intensity;

    private Date time;

    private Float depth;

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getIntensity() {
        return intensity;
    }

    public void setIntensity(Float intensity) {
        this.intensity = intensity;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
