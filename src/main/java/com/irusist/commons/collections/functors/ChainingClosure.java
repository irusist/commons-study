package com.irusist.commons.collections.functors;

import com.irusist.commons.collections.pojo.Shuttle;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.functors.ChainedClosure;

/**
 * ChainedClosure(Closure[] closures)
 * execute(input)方法将input分别传递给closures的execute方法
 * 与Commons Sandbox的CompositeUnaryProcedure类似。
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午6:19
 */
public class ChainingClosure {

    public static void main(String[] args) {
        Closure fuel = new Closure(){
            public void execute(Object input) {
                Shuttle shuttle = (Shuttle) input;
                shuttle.setFuelPercent(100.0);
            }
        };

        Closure repairShielding = new Closure() {
            public void execute(Object input) {
                Shuttle shuttle = (Shuttle) input;
                shuttle.setShieldingReady(true);
            }
        };

        Closure[] cArray = new Closure[]{repairShielding, fuel};
        Closure preLaunch = new ChainedClosure(cArray);

        Shuttle endeavour = new Shuttle();
        endeavour.setName("Endeavour");
        System.out.println("Shuttle before preLaunch: " + endeavour.getFuelPercent() + " " + endeavour.isShieldingReady());

        preLaunch.execute(endeavour);
        System.out.println("Shuttle after preLaunch: " + endeavour.getFuelPercent() + " " + endeavour.isShieldingReady());
    }
}
