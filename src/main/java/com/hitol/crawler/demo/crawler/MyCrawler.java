package com.hitol.crawler.demo.crawler;


import com.hitol.crawler.demo.manager.WebPageManager;
import com.hitol.crawler.demo.model.WebPage;
import com.hitol.crawler.demo.util.UUID;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.regex.Pattern;

@Component
public class MyCrawler extends WebCrawler {


    private WebPageManager manager;

    public MyCrawler(WebPageManager manager) {
        this.manager = manager;
    }

    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 正则表达式匹配指定的后缀文件
     */
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|zip|gz))$");

    /**
     * 这个方法主要是决定哪些url我们需要抓取，返回true表示是我们需要的，返回false表示不是我们需要的Url
     * 第一个参数referringPage封装了当前爬取的页面信息 第二个参数url封装了当前爬取的页面url信息
     * 在这个例子中，我们指定爬虫忽略具有css，js，git，...扩展名的url，只接受以“http://www.ics.uci.edu/”开头的url。
     * 在这种情况下，我们不需要referringPage参数来做出决定。
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        // 得到小写的url
        String href = url.getURL().toLowerCase();
        // 正则匹配，过滤掉我们不需要的后缀文件// 只接受以“http://www.ics.uci.edu/”开头的url
        return !FILTERS.matcher(href).matches()
                && href.startsWith("https://music.163.com/");
    }

    /**
     * 当一个页面被提取并准备好被你的程序处理时，这个函数被调用。
     */
    @Override
    public void visit(Page page) {
        // 获取url
        String url = page.getWebURL().getURL();

        // 判断是否是html数据
        if (page.getParseData() instanceof HtmlParseData) {

//            if (url.contains("song")){
            logger.info("URL = " + url);
            WebPage webPage = new WebPage();
            webPage.setId(UUID.getUuid());
            webPage.setUrl(url);
            manager.saveUrlInfo(webPage);
//            }
//            //// 强制类型转换，获取html数据对象
//            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
//            //获取页面纯文本（无html标签）
//            String text = htmlParseData.getText();
//            //获取页面Html
//            String html = htmlParseData.getHtml();
//            // 获取页面输出链接
//            Set<WebURL> links = htmlParseData.getOutgoingUrls();

//            System.out.println("纯文本长度: " + text.length());
//            System.out.println("html长度: " + html.length());
//            System.out.println("链接个数 " + links.size());
        }
    }
}
