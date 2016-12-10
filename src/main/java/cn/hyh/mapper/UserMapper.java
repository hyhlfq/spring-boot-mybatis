package cn.hyh.mapper;

import cn.hyh.model.User;
import java.util.List;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/8/4 0004
 */

public interface UserMapper {

    User selectUserById(int id);

    List<User> selectUsers();

    int insertUser(User user);

    int updateUserById(User user);

    int deleteUserById(int id);
}
