package com.irusist.commons.velocity.pojo;

/**
 * description
 *
 * @author zhulixin
 */
public class Airport {

    private String code;

    public Airport(String code, String name, int passengers, String countryCode) {
        this.code = code;
        this.name = name;
        this.passengers = passengers;
        this.countryCode = countryCode;
    }

    private String name;

    private int passengers;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String countryCode;

}
