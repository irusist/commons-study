package com.irusist.commons.betwixt;

import com.irusist.commons.betwixt.pojo.Play;
import org.apache.commons.betwixt.XMLIntrospector;
import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.strategy.CapitalizeNameMapper;
import org.apache.commons.betwixt.strategy.HyphenatedNameMapper;

import java.io.InputStream;

/**
 * BeanReader将xml文件内容转化为对象
 *
 * @author zhulixin
 */
public class TurnXMLDocuments2Beans {

    public static void main(String[] args) throws Exception {
        InputStream customPlay = TurnXMLDocuments2Beans.class.getResourceAsStream("/betwixt/config/customized-play.xml");
        BeanReader beanReader = new BeanReader();
        // 去掉characters的元素
        XMLIntrospector introspector = beanReader.getXMLIntrospector();
        introspector.getConfiguration().setWrapCollectionsInElement(false);
        // 属性名用连字符连接
        introspector.getConfiguration().setAttributeNameMapper(new HyphenatedNameMapper());
        // 首字母大写
        introspector.getConfiguration().setElementNameMapper(new CapitalizeNameMapper());
        beanReader.registerBeanClass(Play.class);

        Play play = (Play) beanReader.parse(customPlay);
        System.out.println(play.getSummary());

    }
}
