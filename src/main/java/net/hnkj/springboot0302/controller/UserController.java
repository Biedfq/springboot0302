package net.hnkj.springboot0302.controller;

import net.hnkj.springboot0302.model.User;
import net.hnkj.springboot0302.service.IUserService;
import net.hnkj.springboot0302.utils.JsonData;
import net.hnkj.springboot0302.utils.PageBean;
import net.hnkj.springboot0302.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public JsonData listUser(User user, PageBean pageBean) {
        List<User> users = userService.listUser(user, pageBean);
        JsonData jsonData = new JsonData();
        jsonData.setCode(1);
        jsonData.setMessage("查询成功");
        jsonData.setRows(users);
        jsonData.setTotal(pageBean.getTotal());
        return jsonData;
    }


    @RequestMapping("/login")
    public JsonData login(User user) {
        JsonData jsonData = new JsonData();
        User u = userService.selectUserByUsername(user.getUsername());
        if (u != null) {
            String credentials = PasswordHelper.createCredentials(user.getUsername(), u.getSalt());
            if (u.getPassword().equals(credentials)) {
                jsonData.setCode(1);
                jsonData.setMessage("登入成功");
            } else {
                jsonData.setCode(0);
                jsonData.setMessage("密码错误");
            }

        } else {
            jsonData.setCode(0);
            jsonData.setMessage("用户名不存在");

        }
        return jsonData;
    }


    
}







