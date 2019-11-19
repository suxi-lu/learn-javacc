package com.learn.javacc.cust.asm;

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
public abstract class NoArgRSQLVisitorAdapter<R> implements RSQLVisitor<R, Void> {

    public abstract R visit(AndNode node);

    public abstract R visit(OrNode node);

    public abstract R visit(ComparisonNode node);


    public R visit(AndNode node, Void param) {
        return visit(node);
    }

    public R visit(OrNode node, Void param) {
        return visit(node);
    }

    public R visit(ComparisonNode node, Void param) {
        return visit(node);
    }
}
