package cn.net.wujun;

import cn.net.wujun.common.annotation.ComponentScanExclude;
import cn.net.wujun.common.support.CustomSpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by jasonwu on 2016/10/22.
 */
@SpringBootApplication
@ImportResource("classpath*:META-INF/spring/*.xml")
//@ComponentScan(excludeFilters = @ComponentScan.Filter(ComponentScanExclude.class))
public class Application {

    public static void main(String[] args) {
        CustomSpringApplication.run(Application.class, args);
        //SpringApplication.run(Application.class, args);
    }
}
