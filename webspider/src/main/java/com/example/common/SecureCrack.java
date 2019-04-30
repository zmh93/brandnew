package com.example.common;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SecureCrack {
    public static Map<String, String> genHeader() {
        Map<String, String> map = new HashMap<>();
        map.put("accept","text/htmlapplication/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        map.put("accept-language","zh-CN,zh;q=0.9");
        map.put("accept-encoding", "gzip, deflate");
        map.put("cookie", "_zap=1b35a704-e9a8-4567-9357-bfd0131fa0d1; _xsrf=jEapToNJm2FFkWYVBj2lE0Dn5616zifm; d_c0=\"AFCnaa05Ww-PTjdjhbi0zZlBOjx5C1gNBcE=|1556600064\"; q_c1=718e5cb4e8974c31a4e3eb1d906d4e0a|1556600116000|1556600116000; __gads=ID=291e648235de9590:T=1556600151:S=ALNI_MaUfWmVuD8oXL4QfX14lcgDsXHwgg; __utma=51854390.1945100277.1556601228.1556601228.1556601228.1; __utmb=51854390.0.10.1556601228; __utmc=51854390; __utmz=51854390.1556601228.1.1.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/; __utmv=51854390.100-1|2=registration_date=20140518=1^3=entry_date=20140518=1; tst=h; l_n_c=1; r_cap_id=\"NjMyZmM4YTg4N2I1NDA4MTlhMzdiODdhOTAwYThhZWY=|1556601995|c5128e68be834265a1b97478a76fc47e22c48143\"; cap_id=\"ZTMzNDQyMTVhNWRiNGQ5ZjliNjZiMjg2MmNkMWY2NTg=|1556601995|353457eb423d408bfd924dc10480a9a90409ff99\"; l_cap_id=\"ZWU4MWJjYjQxMDFjNDFkMDhiY2NlNThhN2UyNTE4MTY=|1556601995|54496ef26ce452ad84089398548945b868f07820\"; n_c=1; atoken=232F8184B5335C991F6D83C5796A012D; atoken_expired_in=7776000; client_id=\"OUM3NUZFMTJEMjRDQkYwOUU5Nzk2QUY4NTA0NDY2Nzk=|1556601999|4cbd9a2f1b67037ea7048dc522101a7ee9fd6fc0\"; capsion_ticket=\"2|1:0|10:1556602009|14:capsion_ticket|44:YzgwNTlhOGQzZmE1NDFjN2JjZmVlMTY0YjZmZjI0M2E=|8bfd85f9fbd1e1627ab213d311f9509e7027aaca640492751f05067adf44c209\"; tgw_l7_route=7bacb9af7224ed68945ce419f4dea76d; z_c0=\"2|1:0|10:1556602076|4:z_c0|92:Mi4xZlBkX0R3QUFBQUFBVUtkcHJUbGJEeVlBQUFCZ0FsVk4zQ3ExWFFCcmc1dWxKOFA4QkQ1THRPdjhwREJNeFdfdklB|2eb05f9fe359548b173d86090afb64088fb5e75dbfc8708ff6226c6b094d1eee\"");
        map.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.8 Safari/537.36");
        return map;
    }

    public static ChromeOptions getChromeOptions() {
        return new ChromeOptions()
                .addArguments("cookie: _zap=1b35a704-e9a8-4567-9357-bfd0131fa0d1; _xsrf=jEapToNJm2FFkWYVBj2lE0Dn5616zifm; d_c0=\"AFCnaa05Ww-PTjdjhbi0zZlBOjx5C1gNBcE=|1556600064\"; q_c1=718e5cb4e8974c31a4e3eb1d906d4e0a|1556600116000|1556600116000; __gads=ID=291e648235de9590:T=1556600151:S=ALNI_MaUfWmVuD8oXL4QfX14lcgDsXHwgg; __utma=51854390.1945100277.1556601228.1556601228.1556601228.1; __utmc=51854390; __utmz=51854390.1556601228.1.1.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/; __utmv=51854390.100-1|2=registration_date=20140518=1^3=entry_date=20140518=1; tst=h; l_n_c=1; r_cap_id=\"NjMyZmM4YTg4N2I1NDA4MTlhMzdiODdhOTAwYThhZWY=|1556601995|c5128e68be834265a1b97478a76fc47e22c48143\"; cap_id=\"ZTMzNDQyMTVhNWRiNGQ5ZjliNjZiMjg2MmNkMWY2NTg=|1556601995|353457eb423d408bfd924dc10480a9a90409ff99\"; l_cap_id=\"ZWU4MWJjYjQxMDFjNDFkMDhiY2NlNThhN2UyNTE4MTY=|1556601995|54496ef26ce452ad84089398548945b868f07820\"; n_c=1; client_id=\"OUM3NUZFMTJEMjRDQkYwOUU5Nzk2QUY4NTA0NDY2Nzk=|1556601999|4cbd9a2f1b67037ea7048dc522101a7ee9fd6fc0\"; capsion_ticket=\"2|1:0|10:1556602009|14:capsion_ticket|44:YzgwNTlhOGQzZmE1NDFjN2JjZmVlMTY0YjZmZjI0M2E=|8bfd85f9fbd1e1627ab213d311f9509e7027aaca640492751f05067adf44c209\"; z_c0=\"2|1:0|10:1556602076|4:z_c0|92:Mi4xZlBkX0R3QUFBQUFBVUtkcHJUbGJEeVlBQUFCZ0FsVk4zQ3ExWFFCcmc1dWxKOFA4QkQ1THRPdjhwREJNeFdfdklB|2eb05f9fe359548b173d86090afb64088fb5e75dbfc8708ff6226c6b094d1eee\"; tgw_l7_route=a37704a413efa26cf3f23813004f1a3b\n");
    }
}
