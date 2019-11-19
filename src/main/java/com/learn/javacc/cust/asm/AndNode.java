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
public final class AndNode extends LogicalNode {

    public AndNode(List<? extends Node> children) {
        super(LogicalOperator.AND, children);
    }

    public AndNode withChildren(List<? extends Node> children) {
        return new AndNode(children);
    }

    public <R, A> R accept(RSQLVisitor<R, A> visitor, A param) {
        return visitor.visit(this, param);
    }
}
