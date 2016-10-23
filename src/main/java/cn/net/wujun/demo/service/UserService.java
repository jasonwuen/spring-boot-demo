package cn.net.wujun.demo.service;

import cn.net.wujun.demo.entity.User;

/**
 * Created by jasonwu on 2016/10/22.
 */
public interface UserService {

    String hello(String name);

    User getUser(Long id);
}
