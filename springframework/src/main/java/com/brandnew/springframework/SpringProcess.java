package com.brandnew.springframework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class SpringProcess {

    /**
     * 1. tomcat接收Http请求, 创建Servlet实例
     * 2. Servlet实例即 SpringMvc 的DispatcherServlet 处理请求
     *  2.1 调用 HandlerMapping找到处理器
     *  2.2 调用 HandlerAdapter 调用处理器(controller) 返回 ModelAndView
     * 3. 视图解析
     * 4.试图渲染
     * 5.响应用户
     * @createDate 2019/3/31
     */
    @GetMapping("/index")
    public Object index() {

        return "index";
    }
}
