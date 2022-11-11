package net.hnkj.springboot0302.service;

import net.hnkj.springboot0302.model.User;
import net.hnkj.springboot0302.utils.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    @Transactional(readOnly = true)

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Transactional(readOnly = true)

    List<User> listUser(User user, PageBean pageBean);

    @Transactional(readOnly = true)

    User selectUserByUsername(String username);
}