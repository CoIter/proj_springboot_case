package com.maxsh.mapper;

import com.maxsh.enums.UserSexEnum;
import com.maxsh.model.User;
import com.maxsh.param.UserParam;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * UserMapper
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/05
 */
public interface UserMapper {
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "sex",  column = "sex", javaType = UserSexEnum.class),
    })
    List<User> getAll();

    @SelectProvider(type = UserSqlProvider.class, method = "getList")
    List<User> getList(UserParam userParam);

    @SelectProvider(type = UserSqlProvider.class, method = "getCount")
    int getCount(UserParam userParam);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "sex",  column = "sex", javaType = UserSexEnum.class),
    })
    User getOne(Long id);

    @Insert("INSERT INTO user(name,password,sex,age) VALUES(#{name}, #{password}, #{sex}, #{age})")
    void insert(User user);

    @Update("UPDATE user SET name=#{name},age=#{age} WHERE id =#{id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    int delete(Long id);


    class UserSqlProvider{
        private static final Logger log = LoggerFactory.getLogger(UserSqlProvider.class);
        private final String USER = "user";
        public String getList(UserParam userParam) {
            SQL sql = new SQL().SELECT("*").FROM(USER).WHERE(" 1=1 ");
            if (userParam != null) {
                if (!StringUtils.isEmpty(userParam.getName())) {
                    sql.AND().WHERE(" name= #{name}");
                }
                if (!StringUtils.isEmpty(userParam.getSex())) {
                    sql.AND().WHERE(" sex = #{sex}");
                }
            }
            return sql.toString();
        }

        public String getCount(UserParam userParam) {
            String sql= new SQL(){{
                SELECT("count(1)");
                FROM(USER);
                if (!StringUtils.isEmpty(userParam.getName())) {
                    WHERE("name = #{name}");
                }
                if (!StringUtils.isEmpty(userParam.getSex())) {
                    WHERE("sex = #{sex}");
                }
                //从这个toString可以看出，其内部使用高效的StringBuilder实现SQL拼接
            }}.toString();

            log.info("getCount sql is :" +sql);
            return sql;
        }
    }
}
