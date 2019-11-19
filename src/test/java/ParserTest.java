import com.learn.javacc.cust.RSQLParser;
import com.learn.javacc.cust.asm.Node;
import org.junit.Test;

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
 * @Package PACKAGE_NAME
 */
public class ParserTest {

    @Test
    public void parserTest() {
        String query = "genres=in=(sci-fi,action);genres=out=(romance,animated,horror),director=='Que*Tarantino'";
//        String query = "genres=in=(sci-fi,action);(director=='Christopher Nolan',actor==*Bale);year=ge=2000";
//        String query = "director.lastName==Nolan;year=ge=2000;year=lt=2010";

        RSQLParser rsqlParser = new RSQLParser();
        Node node = rsqlParser.parse(query);

        System.out.println();
    }

}
