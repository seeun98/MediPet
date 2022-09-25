package com.dev.mediPet.src.user;

import com.dev.mediPet.src.user.model.KakaoUserInfo;
import com.dev.mediPet.src.user.utils.KakaoApiService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.annotation.*;

@Repository
@Mapper
public class userDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public userDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource); //자동으로 injection
    }


    public List<KakaoUserInfo> getUsers(){
        String getUserQuery = "select * from user";
        return this.jdbcTemplate.query(getUserQuery,
                (rs, rowNum) -> new KakaoUserInfo(rs.getString("userName"), rs.getString("email")));

    }


}
