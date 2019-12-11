package com.maxsh.repository;

import com.maxsh.model.UserDetailEntity;
import com.maxsh.param.UserDTO;
import com.maxsh.param.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * UserDetailRepository
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/11
 */
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long>,
        JpaSpecificationExecutor<UserDetailEntity> {


    @Query("select new com.maxsh.param.UserInfo(u.userName, u.email, d.introduction , d.hobby) " +
            "from UserEntity u , UserDetailEntity d " +
            "where u.id=d.userId  and  d.hobby = ?1 ")
    List<UserInfo> findUserInfo(String hobby);


    @Query(value=("select u.user_name as userName, u.email as email, d.introduction as introduction , d.hobby as " +
            "hobby" +
            " from user u , user_detail d " +
            "where u.id=d.user_id  and  d.hobby = ?1 "), nativeQuery = true)
    List<UserDTO> findUserDTO(String hobby);
}
