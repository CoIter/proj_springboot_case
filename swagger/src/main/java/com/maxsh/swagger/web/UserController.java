package com.maxsh.swagger.web;


import com.maxsh.swagger.base.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.maxsh.swagger.domain.User;
import com.maxsh.swagger.repository.UserRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * UserController
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/02
 */
@Api(tags={"1-用户管理"})
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取所有用户
     * @return
     */
    @ApiOperation(value = "用户列表", notes = "完整的用户内容列表",produces="application/json, application/xml",
            consumes="application/json, application/xml")
    @GetMapping("/users")
    public Result<List<User>> list() {
        List<User> userList = userRepository.findAll();
        return Result.success(userList);
    }

    /**
     * 创建一个用户
     * @param user
     * @return
     */
    @ApiOperation(value = "添加用户", notes = "根据参数创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, dataType = "String", paramType =
                    "query"),
    })
    @PostMapping("/user")
    public Result<User> create(@ApiIgnore User user) {
        User save = userRepository.save(user);
        return Result.success(save);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户", notes = "根据参数修改用户")
    @PutMapping("/user")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 103, message = "禁止访问"),
            @ApiResponse(code = 104, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<User> modify(User user) {
        User update = userRepository.update(user);
        return Result.success(update);
    }

    /**
     * 更新user中的name字段
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户名", notes = "根据参数更新用户名")
    @PatchMapping("/user/name")
    public Result<User> patch(User user) {
        User user1 = userRepository.UpdateName(user);
        return Result.success(user1);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @ApiOperation(value = "查询用户", notes = "根据id查询用户")
    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable String id) {
        User user = userRepository.findUser(id);
        return Result.success(user);
    }

    /**
     * 删除用户
     * @param id
     */
    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        userRepository.deleteUser(id);
    }
}
