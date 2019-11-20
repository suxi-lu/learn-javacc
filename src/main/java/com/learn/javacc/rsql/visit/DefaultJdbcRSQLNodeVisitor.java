package com.learn.javacc.rsql.visit;

import com.learn.javacc.rsql.asm.ConditionSymbol;
import com.learn.javacc.rsql.asm.Node;
import com.learn.javacc.rsql.asm.WhereNode;
import com.learn.javacc.rsql.util.NodeUtils;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 21:18
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.javacc.rsql.visit
 */
public class DefaultJdbcRSQLNodeVisitor extends BaseRSQLNodeVisitor<String, Void> {

    @Override
    public String visitOrAndNode(List<Node> nodeList, ConditionSymbol conditionSymbol, Void param) {
        List<String> result = handlerChildren(nodeList, param);

        return NodeUtils.getJdbcMultiWhere(result, conditionSymbol.name());
    }

    @Override
    public String visit(WhereNode node, Void stringBuilder) {
        return NodeUtils.getJdbcWhere(node);
    }

}
