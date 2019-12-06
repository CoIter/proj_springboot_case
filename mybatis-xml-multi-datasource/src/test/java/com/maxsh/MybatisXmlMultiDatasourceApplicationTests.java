package com.maxsh;

import com.maxsh.enums.UserSexEnum;
import com.maxsh.mapper.one.User1Mapper;
import com.maxsh.mapper.two.User2Mapper;
import com.maxsh.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("测试Mybatis多数据源")
class MybatisXmlMultiDatasourceApplicationTests {

    @Autowired
    private User1Mapper user1Mapper;
    @Autowired
    private User2Mapper user2Mapper;
    @Test
    public void testInsert() throws Exception {
        user1Mapper.insert(new User("aa111", "a123456", UserSexEnum.MAN, 18));
        user1Mapper.insert(new User("bb111", "b123456", UserSexEnum.WOMAN, 16));
        user2Mapper.insert(new User("cc222", "b123456", UserSexEnum.MAN, 21));
    }
}
