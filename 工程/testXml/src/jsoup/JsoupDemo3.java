package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Administrator on 2020/2/23.
 * Document
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path =JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();

        //2.1.1解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.1获取元素对象
        //3.1.1获取所有student对象
        Elements students = document.getElementsByTag("student");
        System.out.println(students);

        System.out.println("------------------------------------------------");
        //3.1.2获取属性名为id的元素对象
        Elements ids = document.getElementsByAttribute("id");
        System.out.println(ids);

        System.out.println("------------------------------------------------");

        //3.1.2获取属性名和属性值的元素对象
        Elements elementsByAttributeValue = document.getElementsByAttributeValue("id", "itcast");
        System.out.println(elementsByAttributeValue);
    }
}