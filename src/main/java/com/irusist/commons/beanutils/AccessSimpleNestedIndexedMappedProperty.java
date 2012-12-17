package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.City;
import com.irusist.commons.beanutils.pojo.Country;
import com.irusist.commons.beanutils.pojo.Region;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PropertyUtils.getProperty(country, "regions[0].cities(richmond).population");
 * 对PropertyUtils.getSimpleProperty,getNestedProperty,getIndexedProperty,getMappedProperty的汇集
 * User: zhulixin
 * Date: 12-11-30
 * Time: 上午11:31
 */
public class AccessSimpleNestedIndexedMappedProperty {

    public static void main(String[] args) {
        City richmond = new City();
        richmond.setName("Richmond");
        richmond.setPopulation(new Long(500000));

        Map<String, City> cities = new HashMap<String, City>();
        cities.put("richmond", richmond);

        Region midAtlantic = new Region();
        midAtlantic.setName("Mid-Atlantic");
        midAtlantic.setCities(cities);

        List<Region> regions = new ArrayList<Region>();
        regions.add(midAtlantic);

        Country country = new Country();
        country.setName("United States");
        country.setRegions(regions);

        Long population = null;
        try {
            population = (Long) PropertyUtils.getProperty(country, "regions[0].cities(richmond).population");
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(population);
    }
}
