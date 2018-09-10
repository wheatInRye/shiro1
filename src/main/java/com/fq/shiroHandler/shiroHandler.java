package com.fq.shiroHandler;

import com.fq.entify.ShiroServiceTest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class shiroHandler {

    @Autowired
    private ShiroServiceTest shiroServiceTest;

    @RequestMapping("/annotation")
    public String test() {
        //注解授权
        shiroServiceTest.test3();

        return "redirect:test.jsp";
    }

    @RequestMapping("/login")
    public String login(User user){
        //获取登陆用户
        Subject subject = SecurityUtils.getSubject();

        //判断该用户是否有登陆权限
        if (!subject.isAuthenticated()){

            //把用户名封装成usernamePasswordTpken对象
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            usernamePasswordToken.setRememberMe(true);

            //执行登陆
            try {
                subject.login(usernamePasswordToken);
            }
            catch (AuthenticationException ex){
                System.out.println("登陆失败  "+ex.getMessage());
            }
        }

        return "list";
    }
}
