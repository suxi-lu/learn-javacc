package com.learn.javacc.cust.asm;

import java.util.Collection;

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
public abstract class Assert {

    public static void isTrue(boolean expression, String message, Object... args) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, args));
        }
    }

    public static void notNull(Object obj, String message, Object... args) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format(message, args));
        }
    }

    public static void notEmpty(Collection col, String message, Object... args) {
        if (col == null || col.isEmpty()) {
            throw new IllegalArgumentException(String.format(message, args));
        }
    }

    public static void notEmpty(Object[] ary, String message, Object... args) {
        if (ary == null || ary.length == 0) {
            throw new IllegalArgumentException(String.format(message, args));
        }
    }

    public static void notBlank(String str, String message, Object... args) {
        if (StringUtils.isBlank(str)) {
            throw new IllegalArgumentException(String.format(message, args));
        }
    }
}
