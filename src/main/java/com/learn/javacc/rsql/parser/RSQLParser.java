package com.learn.javacc.rsql.parser;

import com.learn.javacc.rsql.RSQLOperator;
import com.learn.javacc.rsql.asm.NodeFactory;
import com.learn.javacc.rsql.asm.Node;
import com.learn.javacc.rsql.asm.WhereOperator;
import com.learn.javacc.rsql.exception.GlobalCommonException;
import com.learn.javacc.rsql.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 21:11
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.javacc.rsql
 */
public class RSQLParser {

    private static final Charset ENCODING = StandardCharsets.UTF_8;

    private final NodeFactory nodeFactory;

    public RSQLParser() {
        this(RSQLOperator.defaultOperator());
    }

    public RSQLParser(Set<WhereOperator> whereOperatorSet) {
        if (whereOperatorSet == null || whereOperatorSet.isEmpty()) {
            throw new GlobalCommonException("operator must not be null or empty");
        }

        nodeFactory = new NodeFactory(whereOperatorSet);
    }

    public Node parse(String search) {
        Assert.notNull(search, "search must not be null");

        InputStream inputStream = new ByteArrayInputStream(search.getBytes(ENCODING));
        Parser parser = new Parser(inputStream, ENCODING.name(), nodeFactory);

        try {
            return parser.parse();
        } catch (Exception e) {
            throw new GlobalCommonException("parse resolve error");
        }
    }

}
