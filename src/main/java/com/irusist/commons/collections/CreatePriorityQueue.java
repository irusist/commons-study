package com.irusist.commons.collections;

import com.irusist.commons.collections.pojo.Patient;
import com.irusist.commons.collections.util.PatientPriorityComparator;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.buffer.PriorityBuffer;

import java.util.Date;
import java.util.Iterator;

/**
 * PriorityBuffer与PriorityQueue类似
 * remove方法返回最小的元素
 * User: zhulixin
 * Date: 12-12-10
 * Time: 上午10:45
 */
public class CreatePriorityQueue {

    public static void main(String[] args) {
        Buffer priority = new PriorityBuffer();
        priority.add(2L);
        priority.add(1L);
        priority.add(20L);
        priority.add(7L);
        priority.add(18L);
        priority.add(1L);

        Iterator priorityIterator = priority.iterator();
        while (priorityIterator.hasNext()) {
            Long value = (Long)priorityIterator.next();
            System.out.println("Value: " + value);
        }

        System.out.println("===========================");
        Buffer patients = new PriorityBuffer(new PatientPriorityComparator());
        Patient johnDoe1 = new Patient();
        johnDoe1.setName("John Doe 1");
        johnDoe1.setSeverity(7);
        johnDoe1.setCheckIn(new Date());
        patients.add(johnDoe1);

        Patient johnDoe2 = new Patient();
        johnDoe2.setName("John Doe 2");
        johnDoe2.setSeverity(9);
        johnDoe2.setCheckIn(new Date());
        patients.add(johnDoe2);

        Patient johnDoe3 = new Patient();
        johnDoe3.setName("John Doe 3");
        johnDoe3.setSeverity(9);
        johnDoe3.setCheckIn(new Date());
        patients.add(johnDoe3);

        while (patients.size() > 0) {
            Patient patient = (Patient) patients.remove();
            System.out.println("Patient: " + patient.getName());
        }

    }
}
