package com.hitol.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JsoupTest {
    @Test
    public void test() throws IOException {
        File input = new File("E:/ttt/V2EX.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        Element topics = doc.getElementById("TopicsNode");
        Elements title =  topics.getElementsByClass("item_title");
        for (Element element : title) {
            Elements links = element.getElementsByTag("a");
            for (Element link : links) {
                String linkHref = link.attr("href");
                String linkText = link.text();
                System.out.println(linkHref );
                System.out.println(linkText);
            }
        }
//        System.out.println(title);
//        System.out.println(topics);
    }
}
