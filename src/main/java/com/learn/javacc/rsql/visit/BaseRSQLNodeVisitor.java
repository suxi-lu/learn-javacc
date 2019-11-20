package com.learn.javacc.rsql.visit;

import com.learn.javacc.rsql.asm.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 22:26
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.javacc.rsql.visit
 */
public abstract class BaseRSQLNodeVisitor<R, P> implements RSQLNodeVisitor<R, P> {

    protected List<R> handlerChildren(List<Node> nodeList, P param) {
        List<R> result = new ArrayList<>();
        if (nodeList == null || nodeList.size() == 0) {
            return result;
        }

        for (Node itemNode : nodeList) {
            if (itemNode instanceof OrNode) {
                result.add(visit((OrNode) itemNode, param));
            } else if (itemNode instanceof AndNode) {
                result.add(visit((AndNode) itemNode, param));
            } else if (itemNode instanceof WhereNode) {
                result.add(visit((WhereNode) itemNode, param));
            }
        }

        return result;
    }

    public abstract R visitOrAndNode(List<Node> nodeList, ConditionSymbol conditionSymbol, P param);

    @Override
    public R visit(OrNode node, P param) {
        return visitOrAndNode(node.getChildren(), node.getConditionSymbol(), param);
    }

    @Override
    public R visit(AndNode node, P param) {
        return visitOrAndNode(node.getChildren(), node.getConditionSymbol(), param);
    }

}
