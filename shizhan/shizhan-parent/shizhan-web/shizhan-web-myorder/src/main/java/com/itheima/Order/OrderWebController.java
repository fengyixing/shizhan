package com.itheima.Order;

import com.itheima.order.feign.OrderFeign;
import com.itheima.order.feign.OrderItemFeign;
import com.itheima.order.pojo.Order;
import com.itheima.order.pojo.OrderItem;
import com.itheima.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: shizhan
 * @description
 * @author: Lindiedie
 * @create: 2020-06-23 14:40
 **/
@Controller
@RequestMapping("/order")
public class OrderWebController {
    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private OrderItemFeign orderItemFeign;

    @GetMapping("/findall")
    public String order(Model model) {
        Order order = new Order();
        order.setUsername("changgou");
        Result<List<Order>> list = orderFeign.findList(order);
        List<Order> result = list.getData();
        OrderItem orderItem = new OrderItem();
        Result<List<OrderItem>> itemFeignList = new Result<List<OrderItem>>();
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        for (Order order1 : result) {
            String id = order1.getId();
            orderItem.setOrderId(id);
            itemFeignList = orderItemFeign.findList(orderItem);
            orderItemList = itemFeignList.getData();
        }
        model.addAttribute("orderItemList", orderItemList);
        model.addAttribute("result", result);
        return "myOrder";
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        getData(model);
        return "daifukuan";
    }

    @GetMapping("/commit")
    public String commit(Model model,String id){
        Order order = orderFeign.findById(id).getData();
        model.addAttribute("order",order);
        return "pay";
    }
    @GetMapping("/delete")
    public String delete(Model model,String id) {
        Order order = orderFeign.findById(id).getData();
        order.setIsDelete("1");
        orderFeign.update(order,id);
        getData(model);
        return "daifukuan";
    }

    @GetMapping("/weixinpay")
    public String paynow(Model model, String id) {
        Order order = orderFeign.findById(id).getData();
        order.setPayStatus("1");
        orderFeign.update(order,id);
        model.addAttribute("order",order);
        return "paysuccess";
    }

    /**
     * ddd
     * @param model
     */
    private void getData(Model model){
        Order order = new Order();
        order.setUsername("changgou");
        order.setPayStatus("0");
        order.setIsDelete("0");
        Result<List<Order>> list = orderFeign.findList(order);
        List<Order> payresult = list.getData();
        OrderItem orderItem = new OrderItem();
        Result<List<OrderItem>> payfeignitemList = new Result<List<OrderItem>>();
        List<OrderItem> payItemList = new ArrayList<OrderItem>();
        for (Order payorder : payresult) {
            String id = payorder.getId();
            orderItem.setOrderId(id);
            payfeignitemList = orderItemFeign.findList(orderItem);
            payItemList = payfeignitemList.getData();
        }
        model.addAttribute("result", payresult);
        model.addAttribute("orderItemList", payItemList);
        model.addAttribute("url","/order/delete");
    }
}
