package com.irusist.commons.math;


import org.apache.commons.lang.math.RandomUtils;

/**
 * RandomUtils计算各种随机数
 *
 * @author zhulixin
 */
public class GenerateRandomVariables {

    public static void main(String[] args) {
        int maxVal = 30;
        int randomInt = RandomUtils.nextInt(maxVal);

        boolean randomBoolean = RandomUtils.nextBoolean();
        System.out.println(randomInt);
        System.out.println(randomBoolean);
    }
}
