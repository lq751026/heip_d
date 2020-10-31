package com.example.heip_d.com.example.serivce.impl;

import com.example.heip_d.com.example.bean.Pay;
import com.example.heip_d.com.example.mapper.OrderMapper;
import com.example.heip_d.com.example.mapper.PayMapper;
import com.example.heip_d.com.example.serivce.PaySerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaySeriveimpl implements PaySerive {
    @Autowired
    private PayMapper payMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void saveImg(Integer id, String imgpath) {
        payMapper.saveImg(id,imgpath);
    }

    @Override
    public Pay findByid(Integer id)throws Exception {
        return payMapper.findByID(id);
    }

    @Override
    public void update(Integer integer, Integer id) {
        //Integer user_id = payMapper.update(id);
        payMapper.updateOreders(integer,id);

    }

    @Override
    public Pay findByID(Integer id) {
        return payMapper.findBYID(id);
    }

    @Override
    public void updateCode(Integer id) {
        payMapper.updateCode(id);
    }
}
