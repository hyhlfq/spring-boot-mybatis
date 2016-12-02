package cn.hyh.service;

import cn.hyh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/9/23 0023
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public ModelMap getUsers() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("ret", 0);
        modelMap.addAttribute("msg", "OK");
        modelMap.addAttribute("data", userMapper.selectUsers());
        return modelMap;
    }

    public ModelMap getUserById(int id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("ret", 0);
        modelMap.addAttribute("msg", "OK");
        modelMap.addAttribute("data", userMapper.selectUserById(id));
        return modelMap;
    }
}
