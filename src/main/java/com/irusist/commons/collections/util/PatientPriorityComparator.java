package com.irusist.commons.collections.util;

import com.irusist.commons.collections.pojo.Patient;

import java.util.Comparator;

/**
 * User: zhulixin
 * Date: 12-12-10
 * Time: 上午11:04
 */
public class PatientPriorityComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        int comparision = -1;
        if(o1 instanceof Patient &&
                o2 instanceof Patient){
            Patient p1 = (Patient) o1;
            Patient p2 = (Patient) o2;
            comparision = p1.getSeverity().compareTo(p2.getSeverity());

            if(comparision ==0){
                comparision = p1.getCheckIn().compareTo(p2.getCheckIn());
            }
        }

        return comparision;
    }
}
