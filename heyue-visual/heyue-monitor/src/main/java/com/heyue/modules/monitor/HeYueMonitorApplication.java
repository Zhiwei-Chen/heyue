package com.heyue.modules.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 监控中心
 * 
 * @author heyue
 */
@EnableAdminServer
@SpringCloudApplication
public class HeYueMonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HeYueMonitorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  监控中心启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
