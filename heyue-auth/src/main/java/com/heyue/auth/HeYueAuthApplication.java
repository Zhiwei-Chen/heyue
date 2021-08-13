package com.heyue.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.heyue.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 * 
 * @author heyue
 */
@EnableRyFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HeYueAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HeYueAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  认证授权中心启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
