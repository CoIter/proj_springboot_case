package com.maxsh.jsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * Controller
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/11/25
 */
@Controller
public class JspController {
    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "hello Jsp");
        return "hello";
    }
}
