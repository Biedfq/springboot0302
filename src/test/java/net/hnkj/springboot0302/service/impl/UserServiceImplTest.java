package net.hnkj.springboot0302.service.impl;

import net.hnkj.springboot0302.model.User;
import net.hnkj.springboot0302.service.IUserService;
import net.hnkj.springboot0302.utils.PageBean;
import net.hnkj.springboot0302.utils.PasswordHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService userService;
    private User user;

    @BeforeEach
    public void setup(){
        user = new User();
    }

    @Test
    void insertSelective() {
        user.setUsername("fq");
        String salt = PasswordHelper.createSalt();
        user.setSalt(salt);
        String password = "8888";
        String credentials = PasswordHelper.createCredentials(password,salt);
        user.setPassword(credentials);
        userService.insertSelective(user);

    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void listUser() {
        List<User> users = userService.listUser(user, new PageBean());
        for (User u : users){
            System.out.println(u);
        }
    }

    @Test
    void selectUserByUsername() {
        User fq = userService.selectUserByUsername("fq");
        System.out.println(fq);
    }
}