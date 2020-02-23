package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Administrator on 2020/2/23.
 * Jsoup对象
 *  parse静态方法
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path =JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();

        //2.1.1解析xml文档，加载文档进内存，获取dom树--->Document
//        Document document = Jsoup.parse(new File(path), "utf-8");
//        System.out.println(document);

        //2.1.2解析html或xml文件至html的dom树
        String xmlORhtml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<students>\n" +
                "\t<student number=\"s1\">\n" +
                "\t\t<name>zhangsan</name>\n" +
                "\t\t<age>11</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\n" +
                "\t<student number=\"s2\">\n" +
                "\t\t<name>lisi</name>\n" +
                "\t\t<age>33</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "</students>";
//        Document document = Jsoup.parse(xmlORhtml);
//        System.out.println(document);

        //2.1.3解析远程URL 路径的html或xml文件至本地html的dom树
        URL url= new URL("https://www.baidu.com");
        Document document = Jsoup.parse(url, 50000); //50000表示超时时间，超过这个时间没有获取document对象值则会抛异常
        System.out.println(document);

    }
}