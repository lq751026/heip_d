package com.example.heip_d.com.example.serivce.impl;

import com.example.heip_d.com.example.bean.Notice;
import com.example.heip_d.com.example.mapper.NoticeMapper;
import com.example.heip_d.com.example.serivce.NoticeSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import java.util.List;
@Service
public class NoticeSerivceimpl implements NoticeSerivce {
     @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> findAllAid() {
        return noticeMapper.findAll();
    }
}
