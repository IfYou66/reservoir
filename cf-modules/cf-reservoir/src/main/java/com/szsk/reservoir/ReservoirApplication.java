package com.szsk.reservoir;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 数字书库管理模块
 *
 * @author
 */
@EnableCustomConfig
@EnableRyFeignClients
@EnableCustomSwagger2
@MapperScan("com.szsk.reservoir.*.mapper")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ReservoirApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ReservoirApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  数字水库管理模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
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
