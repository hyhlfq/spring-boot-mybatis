package cn.hyh.controller.v1.user;

import cn.hyh.model.User;
import cn.hyh.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelMap getUsers() {
        logger.info("getUsers");
        return userService.getUsers();
    }

    @ApiOperation(value = "获取用户信息", notes = "根据id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "int")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelMap getUserById(@PathVariable int id) {
        logger.info("getUserById id = " + id);
        return userService.getUserById(id);
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelMap postUser(@RequestBody User user) {
        logger.info("postUser user = " + user.toString());
        return userService.postUser(user);
    }

    @ApiOperation(value = "更新用户信息", notes = "根据url的id来指定更新对象，并根据传过来的user更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModelMap putUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        logger.info("putUser user = " + user.toString());
        return userService.putUser(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来删除指定对象")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "int")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelMap deleteUserById(@PathVariable int id) {
        logger.info("deleteUserById id = " + id);
        return userService.deleteUserById(id);
    }
}
