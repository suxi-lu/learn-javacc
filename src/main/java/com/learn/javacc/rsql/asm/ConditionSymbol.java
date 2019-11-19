package com.learn.javacc.rsql.asm;

import java.util.regex.Pattern;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 21:12
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.javacc.rsql
 */
public class ConditionSymbol {

    private static final Pattern SYMBOL_PATTERN = Pattern.compile("=[a-zA-Z]*=|[><]=?|!=");

}
