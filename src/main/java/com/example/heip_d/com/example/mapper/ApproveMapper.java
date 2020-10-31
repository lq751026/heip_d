package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Approve;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ApproveMapper {


    @Select("select * from approve where user_id=#{id}")
    Approve findByUserId(Integer id);

    @Insert("insert into approve(path_img,name,student_id,user_id,code) values(#{imgpath},#{name},#{student_id},#{user_id},#{i})")
    void saveApprove(String imgpath, String name, String student_id, Integer user_id, Integer i);
}
