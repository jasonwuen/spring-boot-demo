package cn.net.wujun.common.component;

import cn.net.wujun.common.annotation.ComponentScanExclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by jasonwu on 2016/10/22.
 */
@ComponentScanExclude
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE + 10000)
public class DaemonCommandLineRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DaemonCommandLineRunner.class);

    private CountDownLatch _countDownLatch = new CountDownLatch(1);

   /* @Autowired
    CountDownLatch _countDownLatch;*/

    @Override
    public void run(String... args) throws Exception {
        logger.info("countDownLatch-->>>>>>>>>" + _countDownLatch);
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " Spring boot dubbo server started!");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    System.out.println("Runtime.getRuntime().addShutdownHook....");
                    logger.info("Spring boot stopped!");
                } catch (Throwable t) {
                    logger.error(t.getMessage(), t);
                }
                _countDownLatch.countDown();
            }
        });
        _countDownLatch.await();
    }

    //public static void countDown() {
    //    _dubboCountDownLatch.countDown();
    //}
}
