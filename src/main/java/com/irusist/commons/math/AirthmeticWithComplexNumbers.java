package com.irusist.commons.math;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;

import java.text.NumberFormat;

/**
 * Complex a = new Complex(2, 3)创建一个复数2 + 3i
 * Complex.add(Complex)  2个复数相加
 * Complex.divide(Complex) 2个复数相除
 * Complex.multiply(Complex) 2个复数相乘
 * Complex.conjugate() 将1 + 2i转化为1 - 2i
 * ComplexFormat.getInstance().format(Complex)转化为1 + 2i的形式
 * ComplexFormat format = new ComplexFormat("j");
 * format.format(Complex)会输出1 + 2j
 *
 * @author zhulixin
 */
public class AirthmeticWithComplexNumbers {

    public static void main(String[] args) {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(4, 5);
        Complex c = new Complex(0.3, 2);
        Complex e = new Complex(4, 4);

        Complex sum = a.add(b);
        Complex d = c.divide(sum);
        Complex f = e.multiply(d.conjugate());

        System.out.println("D is: " + ComplexFormat.getInstance().format(d));
        System.out.println("F is: " + ComplexFormat.getInstance().format(f));

        double realF = f.getReal();
        double imD = d.getImaginary();
        double answer = realF / imD;

        System.out.println("Answer Re(F)/Im(D): " + NumberFormat.getInstance().format(answer));
        System.out.println(new Complex(1,2).conjugate().getImaginary());

        System.out.println("===========================================");
        Complex impedance = new Complex(1.0, 2.0);
        ComplexFormat format = new ComplexFormat("j");
        System.out.println("Impendance: " + format.format(impedance));
    }
}
