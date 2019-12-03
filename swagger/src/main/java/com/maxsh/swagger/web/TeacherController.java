package com.maxsh.swagger.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TeacherController
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/03
 */
@Api(tags = {"2-教师管理","4-教学管理"})
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
    @ApiOperation(value = "xxx")
    @GetMapping("/xxx")
    public String xxx() {
        return "xxx";
    }
}
