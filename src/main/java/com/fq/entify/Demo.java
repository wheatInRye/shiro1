package com.fq.entify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Demo {
    @Autowired
    public void test1(){
        System.out.println("已经成功了");

    }
}
