package cn.hyh.controller.v1.user;

import cn.hyh.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/8/4 0004
 */

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        User user = new User();
        user.setId(10000);
        user.setName(name);
        user.setAge(30);
        return user;
    }
}

