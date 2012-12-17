package com.irusist.commons.collections;

import com.irusist.commons.collections.pojo.EarthQuake;
import com.irusist.commons.collections.util.MajorQuakePredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.iterators.FilterIterator;

import java.util.*;

/**
 * Iterator majorQuakes = new FilterIterator(quakes.iterator(), majorQuakePredicate);
 * majorQuakes是经过majorQuakePredicate过滤的由quakes组成的iterator。
 * CollectionUtils.filter(quakes, majorQuakePredicate);返回majorQuakePredicate过滤的quakes，其中
 * quakes的值也随着改变了
 * CollectionUtils.select(quakes, majorQuakePredicate);与filter类似，但是quakes不改变
 * CollectionUtils.selectRejected(quakes, majorQuakePredicate);返回与filter的值相反的值。
 * User: zhulixin
 * Date: 12-12-5
 * Time: 下午4:30
 */
public class FilterCollectionWithPredicate {

    public static void main(String[] args) {

        List<EarthQuake> quakes = new ArrayList<EarthQuake>();
        EarthQuake quake1 = new EarthQuake();
        quake1.setLocation("Chicago, 1L");
        quake1.setIntensity(6.4f);
        quake1.setDepth(634.23f);
        quake1.setTime(new Date());
        quakes.add(quake1);

        EarthQuake quake2 = new EarthQuake();
        quake2.setLocation("San Francisco, CA");
        quake2.setIntensity(4.4f);
        quake2.setDepth(63.23f);
        quake2.setTime(new Date());
        quakes.add(quake2);

        Predicate majorQuakePredicate = new MajorQuakePredicate(5.0f, 1000.0f);

        Iterator majorQuakes = new FilterIterator(quakes.iterator(), majorQuakePredicate);

        while (majorQuakes.hasNext()){
            EarthQuake quake = (EarthQuake) majorQuakes.next();
            System.out.println("ALERT! MAJOR QUAKE: " + quake.getLocation() + ": " + quake.getIntensity());
        }

        // CollectionUtils.filter(quakes, majorQuakePredicate);
        // Collection majorQuakes2 = CollectionUtils.select(quakes, majorQuakePredicate);
        Collection majorQuakes2 = CollectionUtils.selectRejected(quakes, majorQuakePredicate);
        System.out.println(quakes);
        System.out.println(majorQuakes2);

    }
}
