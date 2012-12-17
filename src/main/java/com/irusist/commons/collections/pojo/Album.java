package com.irusist.commons.collections.pojo;

/**
 * User: zhulixin
 * Date: 12-12-5
 * Time: 下午6:25
 */
public class Album {

    private String band;

    private String status;

    public Album(String band, String status) {
        this.band = band;
        this.status = status;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
