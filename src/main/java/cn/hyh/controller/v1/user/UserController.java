package cn.hyh.controller.v1.user;

import cn.hyh.model.User;
import cn.hyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/8/4 0004
 */

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelMap getUsers() {
        logger.info("getUsers");
        return userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelMap getUserById(@PathVariable int id) {
        logger.info("getUserById id = " + id);
        return userService.getUserById(id);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ModelMap postUser(@RequestBody User user) {
        logger.info("postUser user = " + user.toString());
        return userService.postUser(user);
    }

    @RequestMapping(value="", method=RequestMethod.PUT)
    public ModelMap putUser(@RequestBody User user) {
        logger.info("putUser user = " + user.toString());
        return userService.putUser(user);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ModelMap deleteUserById(@PathVariable int id) {
        logger.info("deleteUserById id = " + id);
        return userService.deleteUserById(id);
    }
}
