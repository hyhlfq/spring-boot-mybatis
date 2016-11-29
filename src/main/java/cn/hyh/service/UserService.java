package cn.hyh.service;

import cn.hyh.mapper.UserMapper;
import cn.hyh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/9/23 0023
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
