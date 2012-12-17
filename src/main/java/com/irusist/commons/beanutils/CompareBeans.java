package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.ElectricVehicle;
import com.irusist.commons.beanutils.pojo.Engine;
import org.apache.commons.beanutils.BeanComparator;

import java.util.*;

/**
 * Comparator nameCompare = new BeanComparator("name");
 * Collections.sort(countryList, nameCompare);
 * 对countryList的元素按照name属性进行排序。
 * Comparator vehicleCompare = new BeanComparator("engine", engineComparator);
 * Collections.sort(vehicles, vehicleCompare);
 * 是对vehicles里的每个元素取得engine属性，然后根据engineComparator进行排序。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午1:51
 */
public class CompareBeans {

    public static void main(String[] args) {
        /*Country country1 = new Country();
        country1.setName("India");

        Country country2 = new Country();
        country2.setName("Pakistan");

        Country country3 = new Country();
        country3.setName("Afghanistan");

        Country[] countryArray = new Country[]{country1, country2, country3};
        List countryList = Arrays.asList(countryArray);

        Comparator nameCompare = new BeanComparator("name");
        Collections.sort(countryList, nameCompare);

        System.out.println("Sorted Countries:");
        Iterator countryIterator = countryList.iterator();
        while(countryIterator.hasNext()){
            Country country = (Country) countryIterator.next();
            System.out.println("\tCountry: " + country.getName());
        }*/

        Engine engine1 = new Engine();
        engine1.setMilesGallon(60);
        engine1.setPercentElectric(50);

        Engine engine2 = new Engine();
        engine2.setMilesGallon(90);
        engine2.setPercentElectric(50);

        Engine engine3 = new Engine();
        engine3.setMilesGallon(65);
        engine3.setPercentElectric(45);

        ElectricVehicle vehicle1 = new ElectricVehicle();
        vehicle1.setMake("Toy Yoda");
        vehicle1.setModel("Electro");
        vehicle1.setYear(2005);
        vehicle1.setEngine(engine1);

        ElectricVehicle vehicle2 = new ElectricVehicle();
        vehicle2.setMake("Fjord");
        vehicle2.setModel("Photon");
        vehicle2.setYear(2004);
        vehicle2.setEngine(engine2);

        ElectricVehicle vehicle3 = new ElectricVehicle();
        vehicle3.setMake("Ford");
        vehicle3.setYear(2005);
        vehicle3.setModel("Electirc Pinto");
        vehicle3.setEngine(engine3);

        List vehicles = new ArrayList();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);

        Comparator engineComparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                Engine engine1 = (Engine)o1;
                Engine engine2 = (Engine)o2;
                int engine1Temp = engine1.getMilesGallon() * engine1.getPercentElectric();
                int engine2Temp = engine2.getMilesGallon() * engine2.getPercentElectric();

                return new Integer(engine1Temp).compareTo(engine2Temp);

            }
        };

        Comparator vehicleCompare = new BeanComparator("engine", engineComparator);
        Collections.sort(vehicles, vehicleCompare);

        System.out.println("Vehicles Sorted by Efficiency");
        Iterator vehicleIter = vehicles.iterator();
        while(vehicleIter.hasNext()){
            ElectricVehicle vehicle = (ElectricVehicle)vehicleIter.next();
            System.out.println("\tVehicle: " + vehicle.getModel() + ", " +
            vehicle.getEngine().getMilesGallon() + "MPG, " +
            vehicle.getEngine().getPercentElectric() + "% Electric");

        }
    }
}
