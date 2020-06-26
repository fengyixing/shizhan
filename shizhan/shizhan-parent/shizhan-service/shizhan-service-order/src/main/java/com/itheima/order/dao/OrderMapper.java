package com.itheima.order.dao;
import com.itheima.order.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:itheima
 * @Description:Order的Dao
 *****/
public interface OrderMapper extends Mapper<Order> {
}
