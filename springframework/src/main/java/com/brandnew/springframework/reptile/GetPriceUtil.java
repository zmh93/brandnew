package com.brandnew.springframework.reptile;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Dexter
 * @date 2018/7/9
 */
public class GetPriceUtil {

    /**
     * @param url 访问路径
     * @return
     */
    public Document getDocument(String url) {
        try {
            //5000是设置连接超时时间，单位ms
            return Jsoup.connect(url).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        while(true) {
            System.out.print("时钟时间：" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            System.out.println("   价格："+getPrice());
            try {
                Thread.sleep(5000);// 主线程每隔1秒钟，打印当前时钟时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static BigDecimal getPrice() {
        String     s     = HttpUtil.get("https://tbeospre.mytokenpocket.vip/v1/ram_price");
        Map        map   = (Map) JSON.parse(s);
        BigDecimal data  = new BigDecimal(1024.00000);
        BigDecimal data1 = (BigDecimal) map.get("data");
        return data.divide(data1, BigDecimal.ROUND_HALF_DOWN, 6);
    }
}
