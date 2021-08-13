package com.heyue.system;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.heyue.common.security.annotation.EnableCustomConfig;
import com.heyue.common.security.annotation.EnableRyFeignClients;
import com.heyue.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 * 
 * @author heyue
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class HeYueSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HeYueSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
