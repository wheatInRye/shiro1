package com.fq.filterChainDefinitionsFactoryBuilder;

import java.util.LinkedHashMap;

public class FilterChainDefinitionsFactoryBuilder {
    public LinkedHashMap<String,String> filterChainDefinitionsFactoryBuilderMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
                /*/login.jsp = anon
                /login = anon
                /logout = logout
                /admin.jsp = roles[admin]
                /user.jsp = roles[user]
                #everything else requires authentication:
                *//** =authc*/

                map.put("/login.jsp","anon");
                map.put("/login","anon");
                map.put("/logout","logout");
                map.put("/admin.jsp","roles[admin]");
                map.put("/user.jsp","roles[user]");
                map.put("/**","authc");

        return map;
    }
}
