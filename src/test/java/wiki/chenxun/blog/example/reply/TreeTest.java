package wiki.chenxun.blog.example.reply;

import org.junit.Test;

/**
 * @author 陈勋
 * @version 1.0
 * @date 2021-06-22 11:45 上午
 */
public class TreeTest {




    @Test
    public void test(){
        Tree tree=new Tree("tree_1","文章");

        String a= tree.addNode("a",null);
        String b=tree.addNode("b",null);
        tree.addNode("c",a);
        tree.addNode("d",a);
        tree.addNode("e",b);

        tree.print();
    }

}