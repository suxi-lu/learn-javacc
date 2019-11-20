import com.learn.javacc.rsql.RSQLUtils;
import com.learn.javacc.rsql.asm.AndNode;
import com.learn.javacc.rsql.asm.Node;
import com.learn.javacc.rsql.visit.DefaultJdbcRSQLNodeVisitor;
import com.learn.javacc.rsql.visit.RSQLNodeVisitor;
import org.junit.Test;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 21:21
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package PACKAGE_NAME
 */
public class RSQLNodeVisitorTest {

    @Test
    public void visitTest() {
        String search = "(genres=in=('sci-fi','action');((genres=out=('romance','animated','horror'),director=='Que*Tarantino');((d=='1';e=='1',f=='1');b=='2';c=='3'));a=='1')";

        System.out.println(search);

        Node node = RSQLUtils.parse(search);

        RSQLNodeVisitor<String, Void> visitor = new DefaultJdbcRSQLNodeVisitor();

        if (node instanceof AndNode) {
            String result = visitor.visit((AndNode) node, null);

            System.out.println(result);
        }


    }

}
