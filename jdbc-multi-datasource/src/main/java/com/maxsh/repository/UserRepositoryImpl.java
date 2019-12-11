package com.maxsh.repository;

import com.maxsh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRepositoryImpl
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/03
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    @Override
    public int save(User user,JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null){
            jdbcTemplate= primaryJdbcTemplate;
        }
        return jdbcTemplate.update("INSERT INTO user(name, password, age) values(?, ?, ?)",
                user.getName(), user.getPassword(), user.getAge());
    }
    @Override
    public int update(User user) {
        return primaryJdbcTemplate.update("UPDATE user SET name = ? , password = ? , age = ? WHERE id=?",
                user.getName(), user.getPassword(), user.getAge(), user.getId());
    }

    @Override
    public int delete(long id) {
        return primaryJdbcTemplate.update("DELETE FROM user where id = ? ",id);
    }

    @Override
    public List<User> findALL() {
        return primaryJdbcTemplate.query("SELECT * FROM user", new UserRowMapper());
    }

    @Override
    public User findById(long id) {
        return primaryJdbcTemplate.queryForObject("SELECT * FROM user WHERE id=?", new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
    }
}
