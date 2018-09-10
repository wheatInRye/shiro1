package com.fq.entify;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShiroServiceTest {

    @RequiresRoles({"admin"})
    public void test3(){
        System.out.println("ShiroService   " +new Date());
    }
}

