package com.maxsh.helloworld.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/11/21
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }
}
