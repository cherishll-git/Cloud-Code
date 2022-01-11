package com.lyq.service;

import com.lyq.feign.clients.UserClient;
import com.lyq.feign.pojo.User;
import com.lyq.mapper.OrderMapper;
import com.lyq.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.查询用户,利用Feign远程调用
        User user = userClient.findById(order.getUserId());
        // 3.封装user信息
        order.setUser(user);
        // 4.返回
        return order;
    }
}
