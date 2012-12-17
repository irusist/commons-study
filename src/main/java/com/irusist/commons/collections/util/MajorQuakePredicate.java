package com.irusist.commons.collections.util;

import com.irusist.commons.collections.pojo.EarthQuake;
import org.apache.commons.collections.Predicate;

/**
 * User: zhulixin
 * Date: 12-12-5
 * Time: 下午4:39
 */
public class MajorQuakePredicate implements Predicate {

    private Float majorIntensity;

    private Float majorDepth;

    public MajorQuakePredicate(Float majorIntensity, Float majorDepth) {
        this.majorIntensity = majorIntensity;
        this.majorDepth = majorDepth;
    }

    public boolean evaluate(Object object) {
        boolean satisfies = false;

        if(object instanceof EarthQuake){
            EarthQuake quake = (EarthQuake) object;
            if(quake.getIntensity().floatValue() > majorIntensity.floatValue() &&
                    quake.getDepth().floatValue() < majorDepth.floatValue()){
                satisfies = true;
            }
        }

        return satisfies;
    }
}
