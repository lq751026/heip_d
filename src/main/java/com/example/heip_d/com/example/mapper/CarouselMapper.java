package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Carousel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarouselMapper {
    @Select("select  * from carousel")
    public List<Carousel> findAll();
}
