package com.example.heip_d.com.example.serivce;

import com.example.heip_d.com.example.bean.Address;
import com.example.heip_d.com.example.bean.User;

import java.util.List;

public interface UserSerivce {
 public List<User> findAll();
 public void save(User user);
 public void findByuuid(String uuid) throws  Exception;

    User findByEmail(User user)throws Exception;

    User findById(User user1);

    void updateUser(User user);

    void updateText(User user);

    Address findAddressById(Integer add_id);

    Address addressByid(Integer id);

    void saveAddress(Address address);

    User findByIdd(Integer user_id);
}
