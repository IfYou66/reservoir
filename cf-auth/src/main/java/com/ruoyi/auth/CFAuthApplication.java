package com.ruoyi.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 * 
 * @author ruoyi
 */
@EnableRyFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CFAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CFAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  认证授权中心启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "                           __                  \n" +
                "                          / _|                 \n" +
                "   ___ __ _ _ __   __ _  | |_ ___ _ __   __ _  \n" +
                "  / __/ _` | '_ \\ / _` | |  _/ _ \\ '_ \\ / _` | \n" +
                " | (_| (_| | | | | (_| | | ||  __/ | | | (_| | \n" +
                "  \\___\\__,_|_| |_|\\__, | |_| \\___|_| |_|\\__, | \n" +
                "                   __/ |                 __/ | \n" +
                "                  |___/                 |___/  ");
    }
}
