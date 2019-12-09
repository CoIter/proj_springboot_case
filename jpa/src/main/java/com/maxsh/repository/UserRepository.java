package com.maxsh.repository;

import com.maxsh.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/09
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
    UserEntity findByUserNameOrEmail(String username,String email);
}
