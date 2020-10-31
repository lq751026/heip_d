package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Bounty;
import org.apache.ibatis.annotations.Select;

public interface BountyMapper {
       @Select("select * from bounty where id=#{id}")
    public Bounty findById(Integer id);
}
