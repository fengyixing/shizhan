package com.itheima.order.feign;

import com.itheima.order.pojo.OrderItem;
import com.itheima.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @program: shizhan
 * @description
 * @author: Lindiedie
 * @create: 2020-06-23 20:20
 **/
@FeignClient(name = "order")
public interface OrderItemFeign {
    /***
     * 多条件搜索品牌数据
     * @param orderItem
     * @return
     */
    @PostMapping(value = "/orderItem/search")
    Result<List<OrderItem>> findList(@RequestBody(required = false) OrderItem orderItem);
}
