package com.irusist.commons.collections.functors;

import com.irusist.commons.collections.pojo.Car;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.ForClosure;
import org.apache.commons.collections.functors.WhileClosure;

/**
 * WhileClosure(Predicate predicate, Closure closure, boolean doLoop)
 * 如果doLoop为true，会先执行一次closure（相当于do{}(while predicate)形式），如果doLoop为false，则判断predicate，执行closure，
 * 直到predicate为false
 * ForClosure(count, closure)执行count次closure
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午6:35
 */
public class ClosureLoop {

    public static void main(String[] args) {
        Closure drive = new Closure(){
            public void execute(Object input) {
                Car car = (Car) input;
                car.setFuel(car.getFuel() - 1);
            }
        };

        Predicate hasFuel = new Predicate(){
            public boolean evaluate(Object object) {
                Car car = (Car) object;
                return car.getFuel() > 0;
            }
        };

        Closure useAllFuel = new WhileClosure(hasFuel, drive, true);
        Car car = new Car();
        car.setMakeModel("Ford Escort");
        car.setFuel(20);
        System.out.println("Car before while closure:" + car.getFuel());

        useAllFuel.execute(car);
        System.out.println("Car after while closure:" + car.getFuel());


        System.out.println("==============================");
        Car car1 = new Car();
        car1.setMakeModel("Toyota Carmy");
        car1.setFuel(20);

        System.out.println("Car before for closure: " + car1.getFuel());

        Closure driveSome = new ForClosure(5, drive);

        driveSome.execute(car1);

        System.out.println("Car after for closure: " + car1.getFuel());



    }
}
