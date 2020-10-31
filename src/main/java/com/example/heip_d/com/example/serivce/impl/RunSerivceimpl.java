package com.example.heip_d.com.example.serivce.impl;

import com.example.heip_d.com.example.bean.Orders;
import com.example.heip_d.com.example.mapper.OrderMapper;
import com.example.heip_d.com.example.serivce.RunSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RunSerivceimpl implements RunSerivce {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Orders> findAll() {
        return orderMapper.findAll();
    }
}
