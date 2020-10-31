package com.example.heip_d;


import com.example.heip_d.com.example.mapper.GrabMapper;
import com.example.heip_d.com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.UUID;

@SpringBootTest
class HeipDApplicationTests {
 @Autowired
   private JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {

    }

}
