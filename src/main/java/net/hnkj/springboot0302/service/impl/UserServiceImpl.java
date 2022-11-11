package net.hnkj.springboot0302.service.impl;

import net.hnkj.springboot0302.mapper.UserMapper;
import net.hnkj.springboot0302.model.User;
import net.hnkj.springboot0302.service.IUserService;
import net.hnkj.springboot0302.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> listUser(User user, PageBean pageBean) {
        return userMapper.listUser(user);
    }

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
