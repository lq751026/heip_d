package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Status;
import org.apache.ibatis.annotations.Select;

public interface StatusMapper {
     @Select("select * from status where id=#{id}")
 public Status findById(Integer id);
     @Select("select * from status where id=#{id} and status_name=#{sub}")
     public Status findBsyId(Integer id,String sub);
}
