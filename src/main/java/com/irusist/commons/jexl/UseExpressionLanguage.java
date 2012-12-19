package com.irusist.commons.jexl;

import com.irusist.commons.jexl.pojo.Opera;
import org.apache.commons.jexl2.*;

/**
 * Jexl 表达式
 *
 * @author zhulixin
 */
public class UseExpressionLanguage {

    public static void main(String[] args) {
        Opera opera = new Opera();
        opera.setName("The Magic Flute");
        opera.setComposer("Mozart");
        opera.setYear(1791);

        String expr = "opera.year";

        JexlEngine engine = new JexlEngine();
        JexlContext context = new MapContext();
        context.set("opera", opera);

        Expression expression = engine.createExpression(expr);
        Object obj = expression.evaluate(context);
        System.out.println(obj);

    }
}
