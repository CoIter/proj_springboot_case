package com.maxsh;

import com.maxsh.model.UserDetailEntity;
import com.maxsh.param.UserDTO;
import com.maxsh.param.UserInfo;
import com.maxsh.repository.UserDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * UserDetailRepositoryTests
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/11
 */
@SpringBootTest
public class UserDetailRepositoryTests {
    @Resource
    private UserDetailRepository userDetailRepository;

    @Test
    public void testSaveUserDetail() {
        Date             date          = new Date();
        DateFormat       dateFormat    = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String           formattedDate = dateFormat.format(date);
        UserDetailEntity userDetail    =new UserDetailEntity();
        userDetail.setUserId(2L);
        userDetail.setHobby("摸鱼");
        userDetail.setAge(28);
        userDetail.setIntroduction("摸鱼中。。。");
        userDetailRepository.save(userDetail);
    }

    @Test
    public void testUserInfo()  {
        List<UserInfo> userInfos =userDetailRepository.findUserInfo("摸鱼");
        for (UserInfo userInfo:userInfos){
            System.out.println(userInfo.toString());
        }
    }

    @Test
    public void testUserDTO()  {
        List<UserDTO> userInfos =userDetailRepository.findUserDTO("摸鱼");
        for (UserDTO userInfo:userInfos){
            System.out.println(userInfo.getUserName());
            System.out.println(userInfo.getEmail());
            System.out.println(userInfo.getAddress());
            System.out.println(userInfo.getHobby());
        }
    }
}
