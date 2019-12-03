package com.maxsh;

import com.maxsh.model.User;
import com.maxsh.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@DisplayName("测试多数据源")
class JdbMultiDatasourceApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JdbcTemplate   primaryJdbcTemplate;
    @Autowired
    private JdbcTemplate   secondaryJdbcTemplate;

    @Test
    public void testSave() {
        User user =new User();
        user.setName("maxsh");
        user.setPassword("maxsh123");
        user.setAge(28);
        userRepository.save(user,primaryJdbcTemplate);
        userRepository.save(user,secondaryJdbcTemplate);
    }
}
