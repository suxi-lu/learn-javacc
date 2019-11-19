package com.learn.javacc.rsql.asm;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 20:49
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.javacc.rsql
 */
public enum WhereSymbol {

    OR(","),
    AND(";");

    private final String condition;

    WhereSymbol(String condition) {
        this.condition = condition;
    }

    public String toString() {
        return condition;
    }

}
