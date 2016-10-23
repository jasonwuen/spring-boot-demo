package cn.net.wujun.demo.facade;

import cn.net.wujun.demo.entity.User;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by jasonwu on 2016/10/22.
 */
@Path("u")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
public interface UserRestService {

    @GET
    @Path("{id : \\d+}")
    User getUser(@PathParam("id") @Min(value = 1L, message = "User ID must be greater than 1") Long id);
}
