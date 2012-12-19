package com.irusist.commons.math;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.*;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.Sum;

/**
 * StatUtils.min(values)), new Min().evaluate(values) 最小值
 * StatUtils.max(values)),  new Max().evaluate(values) 最大值
 * StatUtils.mean(values)), new Mean().evaluate(values) 平均值
 * StatUtils.product(values)), new Product().evaluate(values) 乘积
 * StatUtils.sum(values)), new Sum().evaluate(values) 求和
 * StatUtils.variance(values)), new Variance().evaluate(values) 方差
 * Percentile percentile = new Percentile();
 * GeometricMean goemean = new GeometricMean();
 * Skewness skewness = new Skewness();
 * Kurtosis kurtosis = new Kurtosis();
 *
 * @author zhulixin
 */
public class CalculateSimpleUnivariateStatistics {

    public static void main(String[] args) {
        double[] values = new double[] {2.3, 5.4, 6.2, 7.3, 23.3};

        System.out.println("min: " + StatUtils.min(values));
        System.out.println("max: " + StatUtils.max(values));
        System.out.println("mean: " + StatUtils.mean(values));
        System.out.println("product: " + StatUtils.product(values));
        System.out.println("sum: " + StatUtils.sum(values));
        System.out.println("variance: " + StatUtils.variance(values));

        System.out.println("======================================");
        Min min = new Min();
        Max max = new Max();
        Mean mean = new Mean();
        Product product = new Product();
        Sum sum = new Sum();
        Variance variance = new Variance();

        System.out.println("min: " + min.evaluate(values));
        System.out.println("max: " + max.evaluate(values));
        System.out.println("mean: " + mean.evaluate(values));
        System.out.println("product: " + product.evaluate(values));
        System.out.println("sum: " + sum.evaluate(values));
        System.out.println("variance: " + variance.evaluate(values));


        Percentile percentile = new Percentile();
        GeometricMean goemean = new GeometricMean();
        Skewness skewness = new Skewness();
        Kurtosis kurtosis = new Kurtosis();

        System.out.println("80 percentile value: " +
                        percentile.evaluate(values, 80.0));
        System.out.println("geometric mean: " + goemean.evaluate(values));
        System.out.println("skewness: " + skewness.evaluate(values));
        System.out.println("kurtosis: " + kurtosis.evaluate(values));
    }
}
