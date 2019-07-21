package top.ewq123.mvcstudy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/hello")
    public String index(Model model) {
        model.addAttribute("what", "fuck");
        return "hello";
    }
}
