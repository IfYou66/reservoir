package com.ruoyi.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class CFSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CFSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
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
