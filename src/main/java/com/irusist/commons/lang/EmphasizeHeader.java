package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.repeat(string,repeat),将字符串重复repeat次
 * StringUtils.center(string, size,padStr),生成size个字符，将string作为中间，前后用padStr来拼接
 * StringUtils.join(array, seperator)以seperator来连接数组中的每个元素。
 * User: zhulixin
 * Date: 12-11-28
 * Time: 下午6:42
 */
public class EmphasizeHeader {

    public static void main(String[] args) {

        EmphasizeHeader header = new EmphasizeHeader();
        String message = header.createHeader("TEST");
        System.out.println(message);
    }

    public String createHeader(String title){
        int width = 30;
        String stars = StringUtils.repeat("dr", width);
        String centered = StringUtils.center(title, width, "dr");
        String heading = StringUtils.join(new Object[]{stars, centered, stars}, "\n");
        return heading;
    }
}
