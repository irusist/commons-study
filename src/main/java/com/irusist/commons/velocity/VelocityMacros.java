package com.irusist.commons.velocity;

import com.irusist.commons.velocity.pojo.Appointment;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

/**
 * 定义marco
 * #macro(macroName $arg1 $arg2 $arg3)
 *
 * #end
 * 引用macro：#macroName($arg1 $arg2 $arg3)
 *
 * @author zhulixin
 */
public class VelocityMacros {

    public static void main(String[] args) throws Exception {
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty(RuntimeConstants.VM_CONTEXT_LOCALSCOPE, Boolean.TRUE);
        engine.init();

        Appointment appointment = new Appointment();
        VelocityContext conext = new VelocityContext();
        conext.put("appointment", appointment);

        StringWriter writer = new StringWriter();
        InputStream templateStream = VelocityMacros.class.getResourceAsStream("/velocity/config/macros.vm");
        Reader reader = new InputStreamReader(templateStream);

        engine.evaluate(conext, writer, "test", reader);

        templateStream.close();
    }
}
