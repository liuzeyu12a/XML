package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2020/2/23.
 * 快速查询：
 *      Xpath查询
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //2.1获取student.xml的path
        String path =JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.1.1解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //获取document对象后转成jxDocument
        JXDocument jxDocument = new JXDocument(document);

        //结合Xpath查询
        //需求
        //3.1查询所有student元素
        List<JXNode> jxNodes1 = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }
        System.out.println("-------------------");
        //3.2查询所有student带有name属性元素
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("-------------------");
        //3.2查询所有student带有name属性元素
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        System.out.println("-------------------");

        //3.2查询所有student带有name属性元素
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id=itcast]");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }
    }
}