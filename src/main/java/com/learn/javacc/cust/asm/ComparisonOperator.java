package com.learn.javacc.cust.asm;

import java.util.regex.Pattern;

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
public final class ComparisonOperator {

    private static final Pattern SYMBOL_PATTERN = Pattern.compile("=[a-zA-Z]*=|[><]=?|!=");

    private final String[] symbols;

    private final boolean multiValue;


    /**
     * @param symbols Textual representation of this operator (e.g. <tt>=gt=</tt>); the first item
     *          is primary representation, any others are alternatives. Must match
     *          <tt>=[a-zA-Z]*=|[><]=?|!=</tt>.
     * @param multiValue Whether this operator may be used with multiple arguments. This is then
     *          validated in {@link NodesFactory}.
     *
     * @throws IllegalArgumentException If the {@code symbols} is either <tt>null</tt>, empty,
     *          or contain illegal symbols.
     */
    public ComparisonOperator(String[] symbols, boolean multiValue) {
        Assert.notEmpty(symbols, "symbols must not be null or empty");
        for (String sym : symbols) {
            Assert.isTrue(isValidOperatorSymbol(sym), "symbol must match: %s", SYMBOL_PATTERN);
        }
        this.multiValue = multiValue;
        this.symbols = symbols.clone();
    }

    /**
     * @see #ComparisonOperator(String[], boolean)
     */
    public ComparisonOperator(String symbol, boolean multiValue) {
        this(new String[]{symbol}, multiValue);
    }

    /**
     * @see #ComparisonOperator(String[], boolean)
     */
    public ComparisonOperator(String symbol, String altSymbol, boolean multiValue) {
        this(new String[]{symbol, altSymbol}, multiValue);
    }

    /**
     * @see #ComparisonOperator(String[], boolean)
     */
    public ComparisonOperator(String... symbols) {
        this(symbols, false);
    }


    /**
     * Returns the primary representation of this operator.
     */
    public String getSymbol() {
        return symbols[0];
    }

    /**
     * Returns all representations of this operator. The first item is always the primary
     * representation.
     */
    public String[] getSymbols() {
        return symbols.clone();
    }

    /**
     * Whether this operator may be used with multiple arguments.
     */
    public boolean isMultiValue() {
        return multiValue;
    }


    /**
     * Whether the given string can represent an operator.
     * Note: Allowed symbols are limited by the RSQL syntax (i.e. parser).
     */
    private boolean isValidOperatorSymbol(String str) {
        return !StringUtils.isBlank(str) && SYMBOL_PATTERN.matcher(str).matches();
    }


    @Override
    public String toString() {
        return getSymbol();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComparisonOperator)) return false;

        ComparisonOperator that = (ComparisonOperator) o;
        return getSymbol().equals(that.getSymbol());
    }

    @Override
    public int hashCode() {
        return getSymbol().hashCode();
    }
}
