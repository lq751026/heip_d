package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AddressMapper {
    @Select("select * from address where id=#{id}")
    public Address findById(Integer id);

    @Insert("insert into address(address,phone,name) values(#{address},#{phone},#{name})")
    void insert(Address address1);

    @Select("select * from address where name=#{s}")
    Address findBy(String s);
}
