package com.maxsh.mapper.two;

import com.maxsh.model.User;
import com.maxsh.param.UserParam;

import java.util.List;

/**
 * UserMapper
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/05
 */
public interface User2Mapper {
    List<User> getAll();

    List<User> getList(UserParam userParam);

    int getCount(UserParam userParam);

    User getOne(Long id);

    void insert(User user);

    int update(User user);

    int delete(Long id);
}
