package com.maxsh;

import com.maxsh.model.User;
import com.maxsh.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("测试UserRepository")
class JdbcApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("增")
    public void testSave() {
        User user =new User();
        user.setName("maxsh");
        user.setPassword("maxsh123");
        user.setAge(28);
        userRepository.save(user);
    }

    @Test
    @DisplayName("改")
    public void testUpdate() {
        User user =new User();
        user.setName("maxsh");
        user.setPassword("maxsh123");
        user.setAge(18);
        user.setId(1L);
        userRepository.update(user);
    }

    @Test
    @DisplayName("查询")
    public void testQueryOne()  {
        User user=userRepository.findById(1L);
        System.out.println("user--->"+user.toString());
    }

    @Test
    @DisplayName("查询全部")
    public void testQueryAll()  {
        List<User> users =userRepository.findALL();
        for (User user:users){
            System.out.println("user---> "+user.toString());
        }
    }

    @Test
    @DisplayName("删除")
    public void testDetele() {
        userRepository.delete(1L);
    }
}
