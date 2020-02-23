package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2020/2/23.
 * 快速查询：
 *      CSS选择器查询
 */
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path =JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.1.1解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //需求
        //查询标签为name的元素对象
        Elements elementNames = document.select("name");
        System.out.println(elementNames);
        System.out.println("-------------------------");

        //3.1查询id为itcast的元素
        Elements elements = document.select("#itcast");
        System.out.println(elements);
        System.out.println("-------------------------");

        //3.2获取student标签下number属性值为s1的age子标签
        //3.2.1获取student标签下number属性值为s1
        Elements select1 = document.select("student[number=\"s1\"]");
        System.out.println(select1);
        System.out.println("+++++++++++++++++++++++++");
        //3.2获取student标签下number属性值为s1的age子标签
        Elements select2 = document.select("student[number=\"s1\"] > age");
        System.out.println(select2);

    }
}