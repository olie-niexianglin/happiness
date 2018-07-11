package olie.jsoup;

import com.google.common.io.Resources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/10 09:22
 * @Description:
 */
public class Index {
    public static void main(String[] args) {
        URL url = Resources.getResource("index.html");
        File file = new File(url.getPath());

        try {
            Document doc = Jsoup.parse(file, "UTF-8", "http://www.snnu.edu.cn/");
            Element ele = doc.select("#12").first();
            
            System.out.println(ele.attr("hello"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
