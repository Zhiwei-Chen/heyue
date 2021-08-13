package com.heyue.job;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.heyue.common.security.annotation.EnableCustomConfig;
import com.heyue.common.security.annotation.EnableRyFeignClients;
import com.heyue.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author heyue
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class HeYueJobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HeYueJobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
