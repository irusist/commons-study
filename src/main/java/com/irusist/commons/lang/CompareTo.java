package com.irusist.commons.lang;

import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * CompareToBuilder:
 * 生成CompareTo代码
 * CompareToBuilder.reflectionCompare(this, o)不会比较static和transient修饰的字段。
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午3:37
 */
public class CompareTo {

    private static String averageAge;

    private String firstName;

    private String lastName;

    private transient String fullName;

    public static String getAverageAge() {
        return averageAge;
    }

    public static void setAverageAge(String averageAge) {
        CompareTo.averageAge = averageAge;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int compare(Object o){
        int compare = -1;
        if(o != null &&
                CompareTo.class.isAssignableFrom(o.getClass())){
            CompareTo ct = (CompareTo)o;
            // append执行的是栈结构，先比较lastName，如果lastName相等，再比较firstName
            compare = (new CompareToBuilder().append(firstName, ct.firstName)
            .append(lastName, ct.lastName)).toComparison();
        }

        return compare;

        //return CompareToBuilder.reflectionCompare(this, o);
    }
}
