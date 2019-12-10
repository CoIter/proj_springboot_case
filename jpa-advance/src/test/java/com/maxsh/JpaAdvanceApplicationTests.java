package com.maxsh;

import com.maxsh.model.UserEntity;
import com.maxsh.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import javax.xml.ws.soap.Addressing;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest
class JpaAdvanceApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("保存")
    public void testSave() {
        Date       date          = new Date();
        DateFormat dateFormat    = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String     formattedDate = dateFormat.format(date);
        userRepository.save(new UserEntity("aa","aa123456","aa@126.com","aa", "18",formattedDate));
        userRepository.save(new UserEntity("bb","bb123456","bb@126.com","bb","18",formattedDate));
        userRepository.save(new UserEntity("cc","cc123456","cc@126.com","cc","18",formattedDate));
    }


    @Test
    @DisplayName("分页")
    void testPageQuery() {
        int      page     =0;
        int      size     =5;
        Sort     sort     = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<UserEntity> page1 = userRepository.findALL(pageable);
        System.out.println("total--->" + page1.getTotalPages());
        System.out.println("list--->" + page1.getContent());
    }

    @Test
    void testAQuery(){
        int      page     =0;
        int      size     =5;
        Sort     sort     = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        System.out.println( userRepository.findByNickName("aa"));
        System.out.println( userRepository.findByPassWord("cc123456"));
        System.out.println( userRepository.findByNickName("aa", pageable));
        System.out.println( userRepository.findByNickName2("aa", pageable));
    }

    @Test
    void testXz() {
        int      page     =0;
        int      size     =5;
        Sort     sort     = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        System.out.println( userRepository.findFirstByOrderByNickNameAsc());
        System.out.println( userRepository.findTopByOrderByAgeDesc());
        System.out.println( userRepository.queryFirst10ByNickName("aa", pageable));
        System.out.println( userRepository.findFirst10ByNickName("aa", Sort.by(Sort.Direction.DESC, "id")));
        System.out.println( userRepository.findTop10ByNickName("aa", pageable));
    }
}
