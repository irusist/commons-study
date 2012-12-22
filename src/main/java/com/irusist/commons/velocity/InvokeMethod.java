package com.irusist.commons.velocity;

import com.irusist.commons.velocity.pojo.ResultS;
import com.irusist.commons.velocity.pojo.Student;
import com.irusist.commons.velocity.util.StatUtil;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.swing.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author zhulixin
 */
public class InvokeMethod {

    public static void main(String[] args) throws  Exception {
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty("velocimacro.library", "velocity/config/macros2.vm");
        engine.setProperty("resource.loader", "class");
        engine.setProperty("class.resource.loader.description", "Classpath Loader");
        engine.setProperty("class.resource.loader.class", "org.apache.velocity." +
                "runtime.resource.loader.ClasspathResourceLoader");
        engine.init();
//        engine.init("velocity/config/velocity.properties");

        VelocityContext context = new VelocityContext();
        context.put("results", testResults());
        context.put("stat", new StatUtil());

        StringWriter writer = new StringWriter();
        engine.mergeTemplate("velocity/config/results.vm", context, writer);

        System.out.println(writer.toString());
    }

    private static Object testResults() {
        ResultS results = new ResultS();
        int[] scores = {40, 90, 80, 78, 85};
        results.setScores(scores);
        List<Student> students = new ArrayList<Student>();
        results.setStudents(students);
        Student student = new Student();
        student.setName("Tim O.");
        student.setScore(40);
        students.add(student);

        Student student2 = new Student();
        student2.setName("Susan P.");
        student2.setScore(90);
        students.add(student2);

        return results;

    }
}
