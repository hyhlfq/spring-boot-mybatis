package cn.hyh.controller.v1.user;

import cn.hyh.model.User;
import cn.hyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/8/4 0004
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        logger.info("getUserById id = " + id);
        return userService.getUserById(id);
    }
}
