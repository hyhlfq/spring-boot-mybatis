package cn.hyh.service;

import cn.hyh.mapper.UserMapper;
import cn.hyh.model.User;
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

    public ModelMap postUser(User user) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("ret", 0);
        modelMap.addAttribute("msg", "OK");
        userMapper.insertUser(user);
        return modelMap;
    }

    public ModelMap putUser(User user) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("ret", 0);
        modelMap.addAttribute("msg", "OK");
        userMapper.updateUserById(user);
        return modelMap;
    }

    public ModelMap deleteUserById(int id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("ret", 0);
        modelMap.addAttribute("msg", "OK");
        userMapper.deleteUserById(id);
        return modelMap;
    }
}
