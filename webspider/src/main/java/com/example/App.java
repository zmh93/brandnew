package com.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static com.example.common.SecureCrack.ZH_COOKIE;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws IOException, InterruptedException {
        startCrawl();
    }

    public static void startCrawl() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.zhihu.com/api/v4/members/guoxintao/followees?include=data%5B*%5D.answer_count%2Carticles_count%2Cgender%2Cfollower_count%2Cis_followed%2Cis_following%2Cbadge%5B%3F(type%3Dbest_answerer)%5D.topics&offset=0&limit=75");
        httpGet.addHeader("accept","text/htmlapplication/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        httpGet.addHeader("accept-language","zh-CN,zh;q=0.9");
        httpGet.addHeader("accept-encoding", "gzip, deflate");
        httpGet.addHeader("cookie", ZH_COOKIE);
        httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.8 Safari/537.36");

        CloseableHttpResponse response1 = httpclient.execute(httpGet);

        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();

            String jsonString = EntityUtils.toString(entity1);
            System.out.println(jsonString);
        } finally {
            response1.close();
        }
    }

}
