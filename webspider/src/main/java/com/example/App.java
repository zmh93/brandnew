package com.example;

import com.example.common.SecureCrack;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {

    public static String getUrl(String userName) {
        return "https://www.zhihu.com/people/"+userName+"/following";
    }

    public static void main( String[] args ) throws IOException, InterruptedException {
        String url = getUrl("magicwool");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(SecureCrack.getChromeOptions());
        driver.get(url);
        Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        resolveHtml(pageSource);
        driver.close();
    }

    public static void resolveHtml(String html){
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("a[class='UserLink-link']");
        for (Element element : elements) {
            String subscribe = element.text();
            System.out.println(subscribe);
        }
    }

}
