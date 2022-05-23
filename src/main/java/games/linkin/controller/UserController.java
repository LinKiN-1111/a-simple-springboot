package games.linkin.controller;


import games.linkin.pojo.User;
import games.linkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String login(@RequestBody User user, HttpServletRequest req){

        User loginUser = userService.login(user);

        if(null != loginUser){
            //设置session
            //1. 获取session对象
            HttpSession session = req.getSession();
            //2. 设置session对象
            session.setAttribute("linkin","success");
            //3. 返回成功响应
            return "success";
        }else{
            System.out.println("用户名或密码错误");
        }
        return null;
    }

}
