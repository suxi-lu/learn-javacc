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
import java.util.ArrayList;
import java.util.List;

/**
 * This node represents a comparison with operator, selector and arguments,
 * e.g. <tt>name=in=(Jimmy,James)</tt>.
 */
public final class ComparisonNode extends AbstractNode {

    private final ComparisonOperator operator;

    private final String selector;

    private final List<String> arguments;


    /**
     * @param operator Must not be <tt>null</tt>.
     * @param selector Must not be <tt>null</tt> or blank.
     * @param arguments Must not be <tt>null</tt> or empty. If the operator is not
     *          {@link ComparisonOperator#isMultiValue() multiValue}, then it must contain exactly
     *          one argument.
     *
     * @throws IllegalArgumentException If one of the conditions specified above it not met.
     */
    public ComparisonNode(ComparisonOperator operator, String selector, List<String> arguments) {
        Assert.notNull(operator, "operator must not be null");
        Assert.notBlank(selector, "selector must not be blank");
        Assert.notEmpty(arguments, "arguments list must not be empty");
        Assert.isTrue(operator.isMultiValue() || arguments.size() == 1,
                "operator %s expects single argument, but multiple values given", operator);

        this.operator = operator;
        this.selector = selector;
        this.arguments = new ArrayList<>(arguments);
    }


    public <R, A> R accept(RSQLVisitor<R, A> visitor, A param) {
        return visitor.visit(this, param);
    }

    public ComparisonOperator getOperator() {
        return operator;
    }

    /**
     * Returns a copy of this node with the specified operator.
     *
     * @param newOperator Must not be <tt>null</tt>.
     */
    public ComparisonNode withOperator(ComparisonOperator newOperator) {
        return new ComparisonNode(newOperator, selector, arguments);
    }

    public String getSelector() {
        return selector;
    }

    /**
     * Returns a copy of this node with the specified selector.
     *
     * @param newSelector Must not be <tt>null</tt> or blank.
     */
    public ComparisonNode withSelector(String newSelector) {
        return new ComparisonNode(operator, newSelector, arguments);
    }

    /**
     * Returns a copy of the arguments list. It's guaranteed that it contains at least one item.
     * When the operator is not {@link ComparisonOperator#isMultiValue() multiValue}, then it
     * contains exactly one argument.
     */
    public List<String> getArguments() {
        return new ArrayList<>(arguments);
    }

    /**
     * Returns a copy of this node with the specified arguments.
     *
     * @param newArguments Must not be <tt>null</tt> or empty. If the operator is not
     *          {@link ComparisonOperator#isMultiValue() multiValue}, then it must contain exactly
     *          one argument.
     */
    public ComparisonNode withArguments(List<String> newArguments) {
        return new ComparisonNode(operator, selector, newArguments);
    }


    @Override
    public String toString() {
        String args = arguments.size() > 1
                ? "('" + StringUtils.join(arguments, "','") + "')"
                : "'" + arguments.get(0) + "'";
        return selector + operator + args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComparisonNode)) return false;
        ComparisonNode that = (ComparisonNode) o;

        return arguments.equals(that.arguments)
                && operator.equals(that.operator)
                && selector.equals(that.selector);
    }

    @Override
    public int hashCode() {
        int result = selector.hashCode();
        result = 31 * result + arguments.hashCode();
        result = 31 * result + operator.hashCode();
        return result;
    }
}
