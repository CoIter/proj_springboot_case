package com.maxsh.repository;

import com.maxsh.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserRepository
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/09
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select u from UserEntity u")
    Page<UserEntity> findALL(Pageable pageable);

    @Query(value="select u.* from user u where u.nick_name = ?1", nativeQuery = true)
    Page<UserEntity> findByNickName(String nickName, Pageable pageable);

    @Query(value="select u.* from user u where u.nick_name = :nickName", nativeQuery = true)
    Page<UserEntity> findByNickName2(@Param("nickName") String nickName, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update UserEntity set userName = ?1 where id = ?2")
    int modifyById(String  userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from UserEntity where id = ?1")
    void deleteByUserId(Long id);

    List<UserEntity> findByPassWord(String passWord);
    List<UserEntity> findByNickName(String nickName);

    UserEntity findFirstByOrderByNickNameAsc();

    UserEntity findTopByOrderByAgeDesc();

    Page<UserEntity> queryFirst10ByNickName(String nickName, Pageable pageable);

    List<UserEntity> findFirst10ByNickName(String nickName, Sort sort);

    List<UserEntity> findTop10ByNickName(String nickName, Pageable pageable);
}
