package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2020/2/23.
* 步骤：
     1. 导入jar包
     2. 获取Document对象
     3. 获取对应的标签Element对象
     4. 获取数
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path =JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.获取元素对象 Element
        Elements elements = document.getElementsByTag("name");

        //3.1输出大小
        System.out.println(elements.size());

        //3.2获取list中的首对象
        Element element = elements.get(0);
        String text = element.text();
        //3.3输出第一个student 的name
        System.out.println(text);
    }
}