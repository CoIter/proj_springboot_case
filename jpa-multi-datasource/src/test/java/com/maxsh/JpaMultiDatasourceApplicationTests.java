package com.maxsh;

import com.maxsh.model.UserEntity;
import com.maxsh.repository.test1.UserTest1Repository;
import com.maxsh.repository.test2.UserTest2Repository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@SpringBootTest
class JpaMultiDatasourceApplicationTests {

    @Resource
    private UserTest1Repository userTest1Repository;
    @Resource
    private UserTest2Repository userTest2Repository;

    @Test
    public void testSave() throws Exception {
        Date       date          = new Date();
        DateFormat dateFormat    = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String     formattedDate = dateFormat.format(date);

        userTest1Repository.save(new UserEntity("aa","aa123456","aa@126.com","aa", "18",formattedDate));
        userTest1Repository.save(new UserEntity("bb","bb123456","bb@126.com","bb","18",formattedDate));
        userTest2Repository.save(new UserEntity("cc","cc123456","cc@126.com","cc","18",formattedDate));
    }

}
