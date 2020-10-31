package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Address;
import com.example.heip_d.com.example.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
  @Select("select * from user")
  public  List<User> findAll();
  @Select("select * from user where id=#{id}")
  public User findById(Integer id);

  @Insert("insert into user(name,user_password,email,code,authentication,time,phone,tou_img) values(#{name},#{user_password},#{email},#{code},#{authentication},#{time},#{phone},'images/p.png') ")
    void save(User user);

  @Select("update user set code=1 where authentication=#{uuid}")
  void findByUUID(String uuid)throws  Exception;

  @Select("select * from user where email=#{email} and user_password=#{user_password}")
  User findByEmail(User user)throws Exception;

  @Update("update user set email=#{email},name=#{name},tou_img=#{tou_img} where id=#{id}")
    void updateUser(User user);

  @Update("update user set email=#{email},name=#{name} where id=#{id}")
  void updateText(User user);

  @Select("select * from address where id=#{add_id}")
  Address findAddressById(Integer add_id);

  @Select("select * from address where id=#{id}")
  Address findByidAddress(Integer id);

  @Update("update address set name=#{name},phone=#{phone},address=#{address} where id=#{id}")
  void saveAdress(Address address);

  @Update("update user set add_id=#{address2Id} where id=#{id}")
  void updateAddress(Integer address2Id, Integer id);
}
