package com.maxsh.swagger.repository;


import com.maxsh.swagger.domain.User;

import java.util.List;

/**
 * UserRepository
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/02
 */
public interface UserRepository {
    List<User> findAll();
    User save(User user);
    User update(User user);
    User UpdateName(User user);
    User findUser(String id);
    void deleteUser(String id);
}
