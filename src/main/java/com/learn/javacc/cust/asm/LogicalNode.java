package com.learn.javacc.cust.asm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
public abstract class LogicalNode extends AbstractNode implements Iterable<Node> {

    private final List<Node> children;

    private final LogicalOperator operator;


    /**
     * @param operator Must not be <tt>null</tt>.
     * @param children Children nodes, i.e. operands; must not be <tt>null</tt>.
     */
    protected LogicalNode(LogicalOperator operator, List<? extends Node> children) {
        assert operator != null : "operator must not be null";
        assert children != null : "children must not be null";

        this.operator = operator;
        this.children = Collections.unmodifiableList(new ArrayList<>(children));
    }


    /**
     * Returns a copy of this node with the specified children nodes.
     */
    public abstract LogicalNode withChildren(List<? extends Node> children);


    /**
     * Iterate over children nodes. The underlying collection is unmodifiable!
     */
    public Iterator<Node> iterator() {
        return children.iterator();
    }

    public LogicalOperator getOperator() {
        return operator;
    }

    /**
     * Returns a copy of the children nodes.
     */
    public List<Node> getChildren() {
        return new ArrayList<>(children);
    }


    @Override
    public String toString() {
        return "(" + StringUtils.join(children, operator.toString()) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogicalNode)) return false;
        LogicalNode nodes = (LogicalNode) o;

        return children.equals(nodes.children)
                && operator == nodes.operator;
    }

    @Override
    public int hashCode() {
        int result = children.hashCode();
        result = 31 * result + operator.hashCode();
        return result;
    }
}
