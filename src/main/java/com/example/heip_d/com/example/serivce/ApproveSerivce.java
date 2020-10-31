package com.example.heip_d.com.example.serivce;

import com.example.heip_d.com.example.bean.Approve;

public interface ApproveSerivce {

    void saveApprove(String s, String name, String imgpath, Approve approve, Integer id);

    Approve findByUseId(Integer id);
}
