package com.irusist.commons.math;

import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 * SimpleRegression  线性规划
 *
 * @author zhulixin
 */
public class EstablishVariableRelationships {

    public static void main(String[] args) {
        SimpleRegression sr = new SimpleRegression();
        sr.addData(0, 0);
        sr.addData(1, 1.2);
        sr.addData(2, 2.6);
        sr.addData(3, 3.2);
        sr.addData(4, 4);
        sr.addData(5, 5);

        System.out.println("intercept: " + sr.getIntercept());

        System.out.println("N: " + sr.getN());

        System.out.println("Slope: " + sr.getSlope());
        System.out.println("Slope Confidence: " + sr.getSlopeConfidenceInterval());

        System.out.println("RSquare: " + sr.getRSquare());
    }
}
