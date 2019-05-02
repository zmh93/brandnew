package com.example.common;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SecureCrack {
    public static final String ZH_COOKIE;
    static{
        ZH_COOKIE = System.getenv("ZH_COOKIE");
    }
    public static Map<String, String> genHeader() {
        Map<String, String> map = new HashMap<>();
        map.put("accept","text/htmlapplication/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        map.put("accept-language","zh-CN,zh;q=0.9");
        map.put("accept-encoding", "gzip, deflate");
        map.put("cookie", ZH_COOKIE);
        map.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.8 Safari/537.36");
        return map;
    }

    public static ChromeOptions getChromeOptions() {
        return new ChromeOptions()
                .addArguments("cookie: "+ZH_COOKIE);
    }
}
