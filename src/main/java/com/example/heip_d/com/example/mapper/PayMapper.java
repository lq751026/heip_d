package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Pay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PayMapper {
    @Update("update pay set pay_img=#{imgpath} where user_id=#{id}")
    void saveImg(Integer id, String imgpath);

    @Select("select * from pay where help_id=#{id} and pay_code=0")
    Pay findByID(Integer id)throws Exception;

    @Update("select user_id from pay where help_id=#{id} ")
    Integer update(Integer id);

    @Select("select * from pay where help_id=#{id}")
    Pay findByid(Integer id)throws Exception;

    @Select("select  * from pay where user_id=#{id} and pay_code=0")
    Pay findBYID(Integer id);

    @Update("update orders set status_id=4,gb_id=3 where user_id=#{user_id} and taker_id=#{help_id} ")
    void updateOreders(Integer help_id, int user_id);

    @Update("update pay set pay_code=1 where help_id=#{id} and pay_code=0")
    void updateCode(Integer id);

    @Insert("insert into pay(user_id,pay_code) values(#{user_id},0)")
    void insert(Integer user_id);

    @Select("select * from pay where user_id=#{user_id} and pay_code=0")
    List<Pay> findByUser_id(Integer user_id);

    @Update("update pay set help_id=#{userId} where id=#{pay_id}")
    void updateHelpId(Integer userId, Integer pay_id);
}
