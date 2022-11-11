package net.hnkj.springboot0302.mapper;

import net.hnkj.springboot0302.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> listUser(User user);

    User selectUserByUsername(String username);
}