package com.learn.javacc.rsql.asm.node;

import com.learn.javacc.rsql.asm.node.ConditionNode;
import com.learn.javacc.rsql.asm.node.ConditionSymbol;
import com.learn.javacc.rsql.asm.node.Node;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 20:31
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.javacc.rsql
 */
public class OrNode extends ConditionNode {

    public OrNode(List<Node> children) {
        super(ConditionSymbol.OR, children);
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new OrNode(children);
    }

}
