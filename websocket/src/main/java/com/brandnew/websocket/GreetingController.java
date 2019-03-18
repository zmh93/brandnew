package com.brandnew.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@CrossOrigin(origins = "*")
public class GreetingController {

    @GetMapping("hello")
    @ResponseBody
    public Object hello() {
        return "hello";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public String greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new SimpleDateFormat("HH:mm:ss").format(new Date())+ ": " + HtmlUtils.htmlEscape(message);
    }

    @MessageMapping("/admin")
    @SendTo("/topic/admin")
    public WSMessage admin(@RequestBody WSMessage message) throws Exception {
        return message;
    }


}
