package cn.hyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/8/2 0002
 */


@SpringBootApplication
@MapperScan("cn.hyh.mapper")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
