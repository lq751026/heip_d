package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.Notice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoticeMapper {
    @Select("select * from notice")
    public List<Notice> findAll();
}
