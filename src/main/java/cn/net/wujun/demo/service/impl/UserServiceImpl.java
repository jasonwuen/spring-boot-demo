package cn.net.wujun.demo.service.impl;

import cn.net.wujun.demo.entity.User;
import cn.net.wujun.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jasonwu on 2016/10/22.
 */
@Service
public class UserServiceImpl implements UserService {

    private final AtomicLong idGen = new AtomicLong();

    @PostConstruct
    public void init() {
        System.out.println("UserServiceImpl........");
    }

    @Override
    public String hello(String name) {
        System.out.println("UserServiceImpl hello " + name);
        return "hello " + name;
    }

    @Override
    public User getUser(Long id) {
        return new User(id, "username" + id);
    }
}
