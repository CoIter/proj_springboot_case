package com.maxsh.service;

import com.maxsh.model.UserDetailEntity;
import com.maxsh.param.UserDetailParam;
import com.maxsh.param.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * UserDetailService
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/11
 */
public interface UserDetailService {
    Page<UserDetailEntity> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
