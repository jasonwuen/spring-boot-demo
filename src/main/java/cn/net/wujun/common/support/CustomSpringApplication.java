package cn.net.wujun.common.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by jasonwu on 2016/10/22.
 */
//@Configuration
public class CustomSpringApplication {


    private static final Logger logger = LoggerFactory.getLogger(CustomSpringApplication.class);

    /**
     * A basic main that can be used to launch an application. This method is useful when
     * application sources are defined via a {@literal --spring.main.sources} command line
     * argument.
     * <p>
     * Most developers will want to define their own main method can call the
     * {@link #run(Object, String...) run} method instead.
     *
     * @param args command line arguments
     * @throws Exception if the application cannot be started
     * @see org.springframework.boot.SpringApplication#run(Object[], String[])
     * @see org.springframework.boot.SpringApplication#run(Object, String...)
     */
    public static void main(String[] args) throws Exception {
        run(new Object[0], args);
    }

    /**
     * Static helper that can be used to run a {@link org.springframework.boot.SpringApplication} from the
     * specified source using default settings.
     *
     * @param source the source to load
     * @param args   the application arguments (usually passed from a Java main method)
     * @return the running {@link ApplicationContext}
     */
    public static ConfigurableApplicationContext run(Object source, String... args) {
        return run(new Object[]{source}, args);
    }

    /**
     * Static helper that can be used to run a {@link org.springframework.boot.SpringApplication} from the
     * specified sources using default settings and user supplied arguments.
     *
     * @param sources the sources to load
     * @param args    the application arguments (usually passed from a Java main method)
     * @return the running {@link ApplicationContext}
     */
    public static ConfigurableApplicationContext run(Object[] sources, String[] args) {
        return new SpringApplicationBuilder().sources(sources).bannerMode(Banner.Mode.OFF).web(false)
                .registerShutdownHook(true).run(args);
    }

    /*@Bean
    public CountDownLatch countDownLatch() {
        logger.info("--->>>>>>count Downlatch");
        return new CountDownLatch(1);
    }*/

}