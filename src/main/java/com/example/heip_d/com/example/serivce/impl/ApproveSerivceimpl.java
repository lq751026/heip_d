package com.example.heip_d.com.example.serivce.impl;

import com.example.heip_d.com.example.bean.Approve;
import com.example.heip_d.com.example.mapper.ApproveMapper;
import com.example.heip_d.com.example.serivce.ApproveSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApproveSerivceimpl implements ApproveSerivce {
    @Autowired
     private ApproveMapper approveMapper;
    @Override
    public void saveApprove(String imgpath, String name, String student_id, Approve approve, Integer user_id) {
        approveMapper.saveApprove(imgpath,name,student_id,user_id, 1);
    }

    @Override
    public Approve findByUseId(Integer id) {
        return approveMapper.findByUserId(id);
    }
}
