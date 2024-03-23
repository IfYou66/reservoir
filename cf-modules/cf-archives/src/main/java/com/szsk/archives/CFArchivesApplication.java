package com.szsk.archives;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 档案模块启动成功
 * 
 * @author
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@MapperScan("com.szsk.archives.*.mapper")
@SpringBootApplication
public class CFArchivesApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CFArchivesApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  档案模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
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
