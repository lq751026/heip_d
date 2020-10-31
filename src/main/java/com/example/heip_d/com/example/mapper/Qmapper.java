package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Aid;

import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface Qmapper {

    @Select("select * from aid")
    public List<Aid> findAllAid();
}
