package cn.hyh.controller.v1.user;

import cn.hyh.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<User> getUser() {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");

        return new ArrayList<User>() {{
            add(new User(10000, "A", 21));
            add(new User(10001, "B", 22));
        }};
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable Integer id) {
        return new User(id, "HYH", 30);
    }
}
