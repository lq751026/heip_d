package com.example.heip_d.com.example.serivce.impl;

import com.example.heip_d.com.example.bean.Carousel;
import com.example.heip_d.com.example.mapper.CarouselMapper;
import com.example.heip_d.com.example.serivce.CarouselSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarouselSerivceimpl implements CarouselSerivce {
    @Autowired
    private CarouselMapper carouselMapper;
    @Override
    public List<Carousel> findAllAid() {
        return carouselMapper.findAll();
    }
}
