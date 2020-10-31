package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Aid;
import org.apache.ibatis.annotations.Select;

public interface AidMapper {
    @Select("select * from aid where id=#{id}")
 public Aid findById(Integer id);
}
