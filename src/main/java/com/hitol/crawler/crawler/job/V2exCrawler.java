package com.hitol.crawler.crawler.job;

import com.hitol.crawler.manager.WebPageManager;
import com.hitol.crawler.model.JobInfo;
import com.hitol.crawler.model.WebPage;
import com.hitol.crawler.util.UUID;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V2exCrawler extends WebCrawler {
    private WebPageManager manager;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public V2exCrawler(WebPageManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return href.startsWith("https://www.v2ex.com/");
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();

        if (page.getParseData() instanceof HtmlParseData) {


            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
//            logger.info(html);

            Document document = Jsoup.parse(html);
            Element topics = document.getElementById("TopicsNode");
            if (topics == null) {
                return;
            }
            Validate.notEmpty("item_title");
            Elements title = topics.getElementsByClass("item_title");
            for (Element element : title) {
                Elements links = element.getElementsByTag("a");
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text();
                    logger.info("linkHref:" + linkHref);
                    logger.info("linkText:" + linkText);

                    JobInfo jobInfo = new JobInfo(linkText, linkHref);
                    manager.saveJobInfo(jobInfo);

                }
            }

        }

    }
}
