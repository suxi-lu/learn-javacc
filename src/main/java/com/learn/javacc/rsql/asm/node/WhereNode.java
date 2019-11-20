package com.learn.javacc.rsql.asm.node;

import com.learn.javacc.cust.asm.Assert;
import com.learn.javacc.rsql.util.StringUtils;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 23:10
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.javacc.rsql.asm
 */
public class WhereNode implements Node {

    private final WhereOperator whereOperator;
    private final String fieldName;
    private final List<String> value;

    public WhereNode(WhereOperator whereOperator, String fieldName, List<String> value) {
        Assert.notNull(whereOperator, "whereOperator must not be null");
        Assert.notBlank(fieldName, "fieldName must not be blank");
        Assert.notEmpty(value, "value list must not be empty");

        this.whereOperator = whereOperator;
        this.fieldName = fieldName;
        this.value = value;
    }

    public WhereOperator getWhereOperator() {
        return whereOperator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        String valueStr = value.size() > 1 ? "('" + StringUtils.join(value, "','") + "')": "'" + value.get(0) + "'";
        return fieldName + whereOperator + valueStr;
    }

}
