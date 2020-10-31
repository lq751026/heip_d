package com.example.heip_d.com.example.serivce;


import com.example.heip_d.com.example.bean.Pay;

public interface PaySerive {
    void saveImg(Integer id, String imgpath);

    Pay findByid(Integer id) throws Exception;

    void update(Integer integer, Integer id);

    Pay findByID(Integer id);

    void updateCode(Integer id);
}
