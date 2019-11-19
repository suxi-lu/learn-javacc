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
public interface Node {

    /**
     * Accepts the visitor, calls its <tt>visit()</tt> method and returns a result.
     *
     * <p>Each implementation must implement this methods exactly as listed:
     * <pre>{@code
     * public <R, A> R accept(RSQLVisitor<R, A> visitor, A param) {
     *     return visitor.visit(this, param);
     * }
     * }</pre>
     *
     * @param visitor The visitor whose appropriate method will be called.
     * @param param An optional parameter to pass to the visitor.
     * @param <R> Return type of the visitor's method.
     * @param <A> Type of an optional parameter passed to the visitor's method.
     * @return An object returned by the visitor (may be <tt>null</tt>).
     */
    <R, A> R accept(RSQLVisitor<R, A> visitor, A param);

    /**
     * Accepts the visitor, calls its <tt>visit()</tt> method and returns the result.
     *
     * This method should just call {@link #accept(RSQLVisitor, Object)} with
     * <tt>null</tt> as the second argument.
     */
    <R, A> R accept(RSQLVisitor<R, A> visitor);
}
