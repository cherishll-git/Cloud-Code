package com.lyq.service;

import com.lyq.mapper.OrderMapper;
import com.lyq.pojo.Order;
import com.lyq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.查询用户,利用restTemplate发送http请求，查询用户
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user信息
        order.setUser(user);
        // 4.返回
        return order;
    }
}
