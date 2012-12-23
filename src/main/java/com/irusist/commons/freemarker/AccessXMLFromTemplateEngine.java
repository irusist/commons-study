package com.irusist.commons.freemarker;

import freemarker.ext.dom.NodeModel;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 用xml提供数据来解析
 * <#list doc.composers.composer as composer>
 *  ${composer.link}          取composers/composer的link节点的值
 *  ${composer.born.@date}    取composers/composer的born节点的date属性的值
 *  ${composer.born.location} 取composers/born节点的location节点的值
 * </#list>
 *
 * 如果在classpth当中有Apache Xalan，则可以用Xpath表达式：
 * <#list doc["composers/composer/born"] as birth>
 *      ${birth.date}           取composers/composer/born节点下的date节点的值
 *      ${birth?parent.name}    取composers/composer/born节点的父节点的name节点的值
 * </#list>
 *
 * ${composers?children} 取composers节点下的所有子节点组成的序列
 * ${composer?parent}    取composer节点的父节点
 * ${composer?root}      返回root，最顶部的节点
 * ${link?ancestors}     返回link节点的所有父节点组成的数组
 * ${link?node_name}     返回元素或属性的名称(link.)
 * ${link?node_type}     返回attribute, element, text, comment, entity等其他的DOM类型
 *
 * @author zhulixin
 */
public class AccessXMLFromTemplateEngine {

    public static void main(String[] args) throws Exception {

        File composers = new File("/freemarker/config/composers.xml");
        NodeModel nodeModel = NodeModel.parse(composers);

        Configuration cfg = new Configuration();
        Map root = new HashMap();
        root.put("doc", nodeModel);

        StringWriter writer = new StringWriter();
        Template template = cfg.getTemplate("composerTable.ftl");
        template.process(root, writer);
        System.out.println(writer.toString());
    }
}
