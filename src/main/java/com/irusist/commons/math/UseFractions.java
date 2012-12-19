package com.irusist.commons.math;

import org.apache.commons.lang3.math.Fraction;

/**
 * 分数
 * Fraction numer1 = Fraction.getFraction(3, 4);
 * Fraction numerator = numer1.multiplyBy(numer2); // number1 乘以 number2
 * Fraction fraction1 = numerator.divideBy(denominator);  // numerator 除以 denominator
 * Fraction result = fraction1.reduce();     // // 将2/4转化为1/2
 *
 * // 相当于23 + 31/37
 * String userInput = "23 31/37";
 * Fraction fraction = Fraction.getFraction(userInput);
 * System.out.println(fraction.doubleValue());
 *
 * String userInput2 = "101/99";
 * String properString = Fraction.getFraction(userInput2).toProperString();
 * // 1 2/99
 * System.out.println(properString);
 *
 * 一些对应的方法：
 * abs()                            分数的绝对值
 * add(Fraction fraction)           加上一个分数
 * subtract(Fraction fraction)      减去一个分数
 * multiplyBy(Fraction fraction)    乘以一个分数
 * divideBy(Fraction fraction)      除以一个分数
 * reduce()                         最小公分母
 * negate()                         取反（-1 * Fraction)
 * invert()                         交换分子与分母
 * getNumerator()                   返回分子
 * getDenominator()                 返回分母
 * getProperNumerator()             返回正确的分子(如7/3 返回 4,-7/3返回4，总是返回正数)
 * getProperWhole()                 返回正确的分数（如7/3 返回1 4/3)
 * pow(int n)                       返回分数的n次幂
 *
 * @author zhulixin
 */
public class UseFractions {

    public static void main(String[] args) {
        // 相当于23 + 31/37
        String userInput = "23 31/37";
        Fraction fraction = Fraction.getFraction(userInput);
        double value = fraction.doubleValue();
        System.out.println(value);
        System.out.println("===============================");

        // 分数
        Fraction numer1 = Fraction.getFraction(3, 4);
        Fraction numer2 = Fraction.getFraction(51, 3509);

        // number1 乘以 number2
        Fraction numerator = numer1.multiplyBy(numer2);
        Fraction denominator = Fraction.getFraction(41, 59);

        // numerator 除以 denominator
        Fraction fraction1 = numerator.divideBy(denominator);
        // 将2/4转化为1/2
        Fraction result = fraction1.reduce();

        System.out.println("as Fraction: " + result.reduce().toString());
        System.out.println("as double: " + result.doubleValue());

        System.out.println("=====================================");

        String userInput2 = "101/99";
        String properString = Fraction.getFraction(userInput2).toProperString();
        // 1 2/99
        System.out.println(properString);

        System.out.println("========================");
        Fraction fraction2 = Fraction.getFraction(10, 10);
        // 10 / 10
        System.out.println(fraction2);
    }

}
