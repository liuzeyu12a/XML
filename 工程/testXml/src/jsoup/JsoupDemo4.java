package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2020/2/23.
 * Element
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path =JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.1.1解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //需求
        //3.1获取标签为student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements.size()); //2
        System.out.println("--------------------");
        //3.2根据属性名称number获取属性值
        Element element = elements.get(0);
        String number = element.attr("number");
        System.out.println(number);
        System.out.println("--------------------");

        //3.3获取文本内容
        String text = element.text();  //输出标签体的所有纯文本内容
        String html = element.html();  //输出标签体中所有内容（包括标签）
        System.out.println(text);
        System.out.println(html);
    }
}