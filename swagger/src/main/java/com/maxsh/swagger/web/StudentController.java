package com.maxsh.swagger.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/03
 */
@Api(tags = {"3-学生管理"})
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @ApiOperation(value = "获取学生清单", tags = "4-教学管理")
    @GetMapping("/list")
    public String bbb() {
        return "bbb";
    }

    @ApiOperation("获取教某个学生的老师清单")
    @GetMapping("/his-teachers")
    public String ccc() {
        return "ccc";
    }

    @ApiOperation("创建一个学生")
    @PostMapping("/aaa")
    public String aaa() {
        return "aaa";
    }
}
