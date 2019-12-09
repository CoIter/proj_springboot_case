package com.maxsh;

import com.maxsh.model.UserEntity;
import com.maxsh.repository.UserRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.StringAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@DisplayName("JPA测试")
class JpaApplicationTests {

    @Resource
    private UserRepository userRepository;

    @Test
    @DisplayName("增删改查")
    void testJpa() {
        Date       date          = new Date();
        DateFormat dateFormat    = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String     formattedDate = dateFormat.format(date);
        userRepository.save(new UserEntity("aa","aa123456","aa@126.com","aa", "18",formattedDate));
        userRepository.save(new UserEntity("bb","bb123456","bb@126.com","bb","18",formattedDate));
        userRepository.save(new UserEntity("cc","cc123456","cc@126.com","cc","18",formattedDate));

        userRepository.delete(userRepository.findByUserName("cc"));
        UserEntity userb = new UserEntity("bb","sdf","bb@126.com","bb","18",formattedDate);
        userb.setId(2L);
        userRepository.save(userb);

        List<UserEntity> list = userRepository.findAll();
        System.out.println(list);

        Assertions.assertThat(2).isEqualTo(list.size());
        Assertions.assertThat("bb").isEqualTo(userRepository.findByUserNameOrEmail("bb","cc@126.com").getNickName());
    }

}
