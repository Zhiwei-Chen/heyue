package com.heyue.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.heyue.common.security.annotation.EnableCustomConfig;
import com.heyue.common.security.annotation.EnableRyFeignClients;
import com.heyue.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 物流模块
 * 
 * @author heyue
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class HeYueTmsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HeYueTmsApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  物流模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
