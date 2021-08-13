package com.heyue.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关启动程序
 * 
 * @author heyue
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HeYueGatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HeYueGatewayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  网关启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
