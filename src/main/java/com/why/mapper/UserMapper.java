package com.why.mapper;

import com.why.pojo.User;

import java.util.List;

/**
 * @author why
 * 2022/10/12 9:54
 */
public interface UserMapper {
    List<User> selectAll();
}
