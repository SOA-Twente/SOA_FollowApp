package com.QuackAttack.FollowApp.web;

import com.QuackAttack.FollowApp.objects.Following;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getfollowing")
    public List<Following> followingList(int user_id) {
        String sql = "SELECT * FROM followings WHERE user_id = " + user_id;

        List<Following> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Following.class));

        return list;
    }


}
