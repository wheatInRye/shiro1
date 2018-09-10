package com.fq.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;

/**
 * SHA1加密
 */
@Controller
public class SecondRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //强转
        UsernamePasswordToken authenticationToken1 = (UsernamePasswordToken) authenticationToken;

        //获取登陆名
        String username = authenticationToken1.getUsername();

        //判断登陆名信息
        if ("unKown".equals(username)){
            throw new UnknownAccountException("不明用户");
        }

        if ("mostener".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }

        //Object password = "123456";
        //通过SHA1加密
        ByteSource bytes = ByteSource.Util.bytes(username);//设置盐值
        Object password = new SimpleHash("SHA1", "123456", bytes, 1024);
        String name = getName();
       // SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,name);

        //盐值加密

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,bytes,name);
        return info;
    }
}
