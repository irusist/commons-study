package com.irusist.commons.lang;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ToStringBuilder:
 * ReflectionToStringBuilder:
 * 通过ReflectionToStringBuilder.toString(this)来自动对一个对象生成
 * toString()方法。这个方法利用AccessibleObject来访问私有变量，
 * 要利用java.lang.reflect.ReflectPermission 来管理SecurityManager。
 * new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("lastName", lastName).append("firstName", firstName).toString();
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午2:26
 */
public class PoliticalCandidate {

    public PoliticalCandidate(String lastName, String firstName, Date dateOfBirth, BigDecimal moneyRaised, State homeStace) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.moneyRaised = moneyRaised;
        this.homeStace = homeStace;
    }

    public static void main(String[] args) {
        State va = new State("VA", "Virginia");

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 1743);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.DAY_OF_MONTH, 13);

        Date dob = calendar.getTime();

        BigDecimal moneyRaised = new BigDecimal(293829292.93);

        PoliticalCandidate candidate = new PoliticalCandidate("Jefferson",
                "Thomas", dob, moneyRaised, va);
        System.out.println(candidate);
    }

    static class State{

        State(String abbreviation, String name) {
            this.abbreviation = abbreviation;
            this.name = name;
        }

        private String abbreviation;

        private String name;

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

       public String toString(){
           return ReflectionToStringBuilder.toString(this);
       }
    }

    private String lastName;

    private String firstName;

    private Date dateOfBirth;

    private BigDecimal moneyRaised;

    private State homeStace;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getMoneyRaised() {
        return moneyRaised;
    }

    public void setMoneyRaised(BigDecimal moneyRaised) {
        this.moneyRaised = moneyRaised;
    }

    public State getHomeStace() {
        return homeStace;
    }

    public void setHomeStace(State homeStace) {
        this.homeStace = homeStace;
    }

    public String toString(){
//        return ReflectionToStringBuilder.toString(this);
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("lastName", lastName)
                .append("firstName", firstName).toString();
    }

}
