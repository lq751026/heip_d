package com.example.heip_d.com.example.serivce.impl;

import com.example.heip_d.com.example.bean.Aid;
import com.example.heip_d.com.example.mapper.Qmapper;
import com.example.heip_d.com.example.serivce.Qserivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Qserivceimpl implements Qserivce {

     @Autowired
     private Qmapper qmapper;
    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Aid> findAllAid() {
        return qmapper.findAllAid();
    }
}
