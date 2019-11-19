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
public abstract class AbstractNode implements Node {

    /**
     * Accepts the visitor, calls its visit() method and returns the result.
     * This method just calls {@link #accept(RSQLVisitor, Object)} with
     * <tt>null</tt> as the second argument.
     */
    public <R, A> R accept(RSQLVisitor<R, A> visitor) {
        return accept(visitor, null);
    }
}
