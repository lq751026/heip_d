package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Stay;
import org.apache.ibatis.annotations.Insert;

public interface StayMapper {
    @Insert("insert into stay(name,phone,text,time) values(#{name},#{phone},#{text},#{time}) ")
      public void save(Stay stay)throws  Exception;
}
