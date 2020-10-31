package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("select * from role where id=#{id}")
   public Role findById(Integer id);
}
