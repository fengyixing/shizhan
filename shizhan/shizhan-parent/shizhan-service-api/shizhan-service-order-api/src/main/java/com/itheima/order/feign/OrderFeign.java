package com.itheima.order.feign;

import com.itheima.order.pojo.Order;
import com.itheima.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: shizhan
 * @description
 * @author: Lindiedie
 * @create: 2020-06-23 14:36
 **/
@FeignClient(name = "order")
public interface OrderFeign {
    @PostMapping(value = "/order/search")
    Result<List<Order>> findList(@RequestBody(required = false) Order order);


    @GetMapping("/order/{id}")
    Result<Order> findById(@PathVariable(value = "id") String id);


    @PutMapping("/order/{id}")
    Result update(@RequestBody(required = false) Order order, @PathVariable(value = "id") String id);
}
