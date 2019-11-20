import com.learn.javacc.rsql.RSQLUtils;
import com.learn.javacc.rsql.asm.Node;
import org.junit.Test;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 20:34
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package PACKAGE_NAME
 */
public class RSQLUtilsTest {

    @Test
    public void parseTest() {
//        String search = "genres=in=(sci-fi,action);((genres=out=(romance,animated,horror),director=='Que*Tarantino');((d==1;e==1;f==1);b==2;c==3));a==1";
        String search = "(genres=in=('sci-fi','action');((genres=out=('romance','animated','horror'),director=='Que*Tarantino');((d=='1';e=='1',f=='1');b=='2';c=='3'));a=='1')";
        System.out.println(search);
        Node node = RSQLUtils.parse(search);

        System.out.println(node.toString());
    }

}
