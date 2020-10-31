package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Grab;
import org.apache.ibatis.annotations.Select;

public interface GrabMapper {
    @Select("select * from grab where id=${id}")
   public Grab findById(Integer id);

    @Select("select * from grab where id=${id}")
    Grab findUrl(Integer id);
}
