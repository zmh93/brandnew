package com.example.spider;

import com.example.common.SecureCrack;
import com.example.model.Pojo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SeleniumSpider {

    public static String getUrl(String userName) {
        return "https://www.zhihu.com/people/"+userName+"/following";
    }

    public void startCrawl() throws InterruptedException {
        String url = getUrl("magicwool");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(SecureCrack.getChromeOptions());
        driver.get(url);
        Thread.sleep(1000);
        String pageSource = driver.getPageSource();
        resolveHtml(pageSource);
        driver.close();
    }

    public static void resolveHtml(String html){
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("div[class='List-item']");
        List<Pojo> list = new ArrayList<>();
        for (Element element : elements) {
            Elements userElements = element.select("div[class=ContentItem-head]").select("a[class=UserLink-link]");
            Element userElement = userElements.get(0);
            String userMain = userElement.attr("href");
            String userName = userElement.text();
            Elements headlineEle = element.select("div[class=ztext]");
            String headline = headlineEle.size()>0?headlineEle.get(0).text():"";
            Elements contentItem = element.select("span[class=ContentItem-statusItem]");
            String replyCount = "";
            String articleCount = "";
            String followCount = "";
            for (Element ele : contentItem) {
                String text = ele.text().replace("\n","").replace("::before","").trim();;
                if (text.contains("回答")) {
                    replyCount = text.replace(" 回答", "");
                } else if (text.contains("文章")) {
                    articleCount = text.replace(" 文章", "");
                }else if (text.contains("关注者")) {
                    followCount = text.replace(" 关注者", "");
                }
            }
            list.add(new Pojo(userMain, userName, headline, replyCount, articleCount, followCount));
        }
        list.forEach(System.out::println);
    }
}
