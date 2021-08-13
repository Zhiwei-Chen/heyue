package com.heyue.wms;

import com.heyue.common.security.annotation.EnableCustomConfig;
import com.heyue.common.security.annotation.EnableRyFeignClients;
import com.heyue.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
/**
 * 仓储管理模块
 *
 * @author wchu
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class HeYueWmsApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(HeYueWmsApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  仓储管理模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
