package cn.net.wujun.test.demo.facade;

import cn.net.wujun.demo.entity.User;
import cn.net.wujun.demo.facade.UserRestService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jasonwu on 2016/10/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/*.xml")
//@ComponentScan(basePackages = {"com.xxx"})
public class UserRestServiceTest {

    @Reference(protocol = "dubbo")
    UserRestService userRestService;

    @Test
    public void testGetUser() {
        System.out.println("-------------->>>>>>>>");
        System.out.println(userRestService);

        User user = userRestService.getUser(1L);
        System.out.println("---->" + user);
        System.out.println(JSON.toJSONString(user));
    }

    @AfterClass
    public static void close() {
        System.out.println("---->");
        System.out.println();
    }
}
