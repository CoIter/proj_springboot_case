package com.maxsh.repository;

import com.maxsh.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * UserRepository
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/03
 */
public interface UserRepository {
    int save(User user, JdbcTemplate jdbcTemplate);
    int update(User user);
    int delete(long id);
    List<User> findALL();
    User findById(long id);
}
