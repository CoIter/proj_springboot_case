package com.maxsh;

import com.maxsh.enums.UserSexEnum;
import com.maxsh.mapper.UserMapper;
import com.maxsh.model.Page;
import com.maxsh.model.User;
import com.maxsh.param.UserParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@DisplayName("测试UserMapper")
class MybatisXmlApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    @DisplayName("测试User增删改查")
    public void testUser()  {
        User user = new User();
        user.setName("张三");
        user.setPassword("zs234");
        user.setAge(18);
        user.setSex(UserSexEnum.MAN);
        //增加
        userMapper.insert(user);
        //删除
        int  count =userMapper.delete(2l);
        User user1  = userMapper.getOne(5l);
        //修改
        userMapper.update(user1);
        //查询
        List<User> users = userMapper.getAll();
    }


    @Test
    @DisplayName("测试分页查询")
    public void testPage() {
        UserParam userParam =new UserParam();
        userParam.setSex("MAN");
        userParam.setCurrentPage(1);
        List<User> users =userMapper.getList(userParam);
        long       count =userMapper.getCount(userParam);
        Page       page  = new Page(userParam,count,users);
        System.out.println(page);
    }

}
