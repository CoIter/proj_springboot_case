package com.maxsh.swagger.web;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.maxsh.swagger.domain.User;
import com.maxsh.swagger.repository.UserRepository;

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
    @GetMapping("/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    /**
     * 创建一个用户
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping("/user")
    public User modify(User user) {
        return userRepository.update(user);
    }

    /**
     * 更新user中的name字段
     * @param user
     * @return
     */
    @PatchMapping("/user/name")
    public User patch(User user) {
        return userRepository.UpdateName(user);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return userRepository.findUser(id);
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        userRepository.deleteUser(id);
    }
}
