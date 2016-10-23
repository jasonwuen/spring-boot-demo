package cn.net.wujun.demo.facade.impl;

import cn.net.wujun.demo.entity.User;
import cn.net.wujun.demo.facade.UserRestService;
import cn.net.wujun.demo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Min;
import javax.ws.rs.PathParam;

/**
 * Created by jasonwu on 2016/10/22.
 */
@Service(protocol = {"rest", "dubbo"})
//@Service
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        System.out.println("-->>>>>>>>PostConstruct");
    }

    @Override
    public User getUser(@PathParam("id") @Min(1L) Long id) {
        //System.out.println("Client name is " + RpcContext.getContext().getAttachment("clientName"));
        //System.out.println("Client impl is " + RpcContext.getContext().getAttachment("clientImpl"));
        return userService.getUser(id);
    }

}
