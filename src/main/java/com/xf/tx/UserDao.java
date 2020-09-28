package com.xf.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author xf
 * @date 2020-09-24 18:29
 * @since 1.0.0
 */
@Repository
public class UserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void insert() {
        String sql = "insert into user (username,age)value(?,?)";
        String substring = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,substring,19);
    }

}
