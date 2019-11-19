package com.learn.javacc.cust.asm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
public abstract class RSQLOperators {

    public static final ComparisonOperator
            EQUAL = new ComparisonOperator("=="),
            NOT_EQUAL = new ComparisonOperator("!="),
            GREATER_THAN = new ComparisonOperator("=gt=", ">"),
            GREATER_THAN_OR_EQUAL = new ComparisonOperator("=ge=", ">="),
            LESS_THAN = new ComparisonOperator("=lt=", "<"),
            LESS_THAN_OR_EQUAL = new ComparisonOperator("=le=", "<="),
            IN = new ComparisonOperator("=in=", true),
            NOT_IN = new ComparisonOperator("=out=", true);


    public static Set<ComparisonOperator> defaultOperators() {
        return new HashSet<>(Arrays.asList(EQUAL, NOT_EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL,
                LESS_THAN, LESS_THAN_OR_EQUAL, IN, NOT_IN));
    }
}
