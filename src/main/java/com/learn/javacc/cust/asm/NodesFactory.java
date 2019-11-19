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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NodesFactory {

    private final Map<String, ComparisonOperator> comparisonOperators;


    public NodesFactory(Set<ComparisonOperator> operators) {

        comparisonOperators = new HashMap<>(operators.size());
        for (ComparisonOperator op : operators) {
            for (String sym : op.getSymbols()) {
                comparisonOperators.put(sym, op);
            }
        }
    }

    /**
     * Creates a specific {@link LogicalNode} instance for the specified operator and with the
     * given children nodes.
     *
     * @param operator The logical operator to create a node for.
     * @param children Children nodes, i.e. operands.
     * @return A subclass of the {@link LogicalNode} according to the specified operator.
     */
    public LogicalNode createLogicalNode(LogicalOperator operator, List<Node> children) {
        switch (operator) {
            case AND : return new AndNode(children);
            case OR  : return new OrNode(children);

            // this normally can't happen
            default  : throw new IllegalStateException("Unknown operator: " + operator);
        }
    }

    /**
     * Creates a {@link ComparisonNode} instance with the given parameters.
     *
     * @param operatorToken A textual representation of the comparison operator to be found in the
     *                      set of supported {@linkplain ComparisonOperator operators}.
     * @param selector The selector that specifies the left side of the comparison.
     * @param arguments A list of arguments that specifies the right side of the comparison.
     *
     * @throws UnknownOperatorException If no operator for the specified operator token exists.
     */
    public ComparisonNode createComparisonNode(
            String operatorToken, String selector, List<String> arguments) throws RuntimeException {

        ComparisonOperator op = comparisonOperators.get(operatorToken);
        if (op != null) {
            return new ComparisonNode(op, selector, arguments);
        } else {
            throw new RuntimeException(operatorToken);
        }
    }
}