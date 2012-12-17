package com.irusist.commons.lang;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * HashCodeBuilder:
 * EqualsBuilder:
 * 自动生成hashCode和equals方法
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午3:22
 */
public class HashCodeEqualsBuilder {

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int hashCode(){
        return new HashCodeBuilder(17, 37).append(firstName).append(lastName).toHashCode();
        // 利用所有的字段产生hashCode
        //return HashCodeBuilder.reflectionHashCode(this);
    }

    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && HashCodeEqualsBuilder.class.isAssignableFrom(o.getClass())){
            HashCodeEqualsBuilder b = (HashCodeEqualsBuilder)o;
            equals = (new EqualsBuilder().append(firstName, b.firstName)
            .append(lastName, b.lastName)).isEquals();
        }
        return equals;
        // 对所有的字段有效
        //return EqualsBuilder.reflectionEquals(this, o);
    }
}
