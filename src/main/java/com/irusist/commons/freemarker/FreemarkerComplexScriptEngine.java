package com.irusist.commons.freemarker;

import com.irusist.commons.freemarker.pojo.Course;
import com.irusist.commons.freemarker.pojo.Enrollment;
import com.irusist.commons.freemarker.pojo.Exam;
import com.irusist.commons.freemarker.pojo.Person;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.*;

/**
 * <#macro macroname param1 param2)>
 *      <#nested/>
 * </#macro>
 *
 * <@macroname param1=value1 param2=value2>body</@macroname>
 *
 * <#if condition1>Result1
 * <#elseif condition2>Result2
 * <#else condition3>Result3
 * </#if>
 *
 * <#assign student = enrollment.student >定义变量
 *
 * 格式化日期和数字
 * ${exam.date?date?string.short} ?date说明只取年，月，日
 * ?string.short说明用短日期格式(12/31/04)
 * ${exam.date?string("MM-dd-yyyy hh:mm:ss)} 会输出12-31-2004 04:23:22
 * freemarker可以比较日期和数字（int 和 float）
 *
 * 在web容器中用freemarker可以用Servlet
 * freemarker.ext.servlet.FreemarkerServlet
 * @author zhulixin
 */
public class FreemarkerComplexScriptEngine {

    public static void main(String[] args) throws Exception {
        StringWriter writer = new StringWriter();

        Configuration cfg = new Configuration();
        cfg.setTemplateLoader(new ClassTemplateLoader(FreemarkerComplexScriptEngine.class, "/freemarker/config"));
        cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);

        Map root = new HashMap();
        root.put("enrollment", testEnrollment());

        Template template = cfg.getTemplate("template.ftl");
        template.process(root, writer);
        System.out.println(writer.toString());
    }

    private static Object testEnrollment() {
        Enrollment enrollment = new Enrollment();
        Person student = new Person();
        student.setFirstName("Stefan");
        student.setLastName("Winz");
        enrollment.setStudent(student);

        Course course = new Course();
        course.setDept("ECON");
        course.setName("Macroeconomics");
        course.setNum(201);
        course.setProfessor("Dr. Stephen H. Jones");
        enrollment.setCourse(course);

        List<Exam> exams = new ArrayList<Exam>();
        Exam exam1 = new Exam();
        exam1.setName("T01");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.OCTOBER, 1);
        exam1.setDate(calendar.getTime());
        exam1.setScore(93.4f);
        exam1.setWeight(1.00f);
        exams.add(exam1);

        Exam exam2 = new Exam();
        exam2.setName("T02");
        calendar.set(2003,Calendar.JANUARY, 17);
        exam2.setDate(calendar.getTime());
        exam2.setScore(85.5f);
        exam2.setWeight(1.50f);
        exams.add(exam2);

        Exam exam3 = new Exam();
        exam3.setName("Mid");
        calendar.set(2003, Calendar.FEBRUARY, 15);
        exam3.setDate(calendar.getTime());
        exam3.setScore(98.0f);
        exam3.setWeight(2.00f);
        exams.add(exam3);

        Exam exam4 = new Exam();
        exam4.setName("T03");
        calendar.set(2003, Calendar.MARCH, 31);
        exam4.setDate(calendar.getTime());
        exam4.setScore(71.5f);
        exam4.setWeight(1.00f);
        exams.add(exam4);

        Exam exam5 = new Exam();
        exam5.setName("T04");
        calendar.set(2003, Calendar.APRIL, 10);
        exam5.setDate(calendar.getTime());
        exam5.setScore(88.5f);
        exam5.setWeight(1.50f);
        exams.add(exam5);

        Exam exam6 = new Exam();
        exam6.setName("Fin");
        calendar.set(2003, Calendar.MAY, 5);
        exam6.setDate(calendar.getTime());
        exam6.setScore(95.0f);
        exam6.setWeight(4.00f);
        enrollment.setExams(exams);
        enrollment.setSection(2);

        return enrollment;
    }
}
