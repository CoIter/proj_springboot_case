package com.maxsh;

import com.maxsh.model.UserDetailEntity;
import com.maxsh.param.UserDetailParam;
import com.maxsh.service.UserDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

/**
 * JpaSpecificationTests
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/11
 */

@SpringBootTest
public class JpaSpecificationTests {
    @Resource
    private UserDetailService userDetailService;

    @Test
    public void testFindByCondition()  {
        int      page     =0;
        int      size     =5;
        Sort     sort     = Sort.by(Sort.Direction.DESC, "id");
        Pageable        pageable = PageRequest.of(page, size, sort);
        UserDetailParam param    =new UserDetailParam();
        param.setIntroduction("程序员");
        param.setMinAge(10);
        param.setMaxAge(30);
        Page<UserDetailEntity> page1 =userDetailService.findByCondition(param,pageable);
        for (UserDetailEntity userDetail:page1){
            System.out.println("userDetail: "+userDetail.toString());
        }
    }
}
