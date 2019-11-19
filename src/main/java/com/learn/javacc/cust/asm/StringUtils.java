package com.learn.javacc.cust.asm;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.javacc.cust
 */
public class StringUtils {

    public static String join(List<?> list, String glue) {
        StringBuilder line = new StringBuilder();
        for (Object s : list) {
            line.append(s).append(glue);
        }
        return list.isEmpty() ? "" : line.substring(0, line.length() - glue.length());
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

}
