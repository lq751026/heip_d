package com.example.heip_d.com.example.serivce.impl;

import com.example.heip_d.com.example.bean.Address;
import com.example.heip_d.com.example.bean.User;
import com.example.heip_d.com.example.mapper.UserMapper;
import com.example.heip_d.com.example.serivce.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSeriivceimpl implements UserSerivce {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void findByuuid(String uuid) throws  Exception {
         userMapper.findByUUID(uuid);
    }

    @Override
    public User findByEmail(User user) throws Exception {
         return userMapper.findByEmail(user);
    }

    @Override
    public User findById(User user1) {
        return userMapper.findById(user1.getId());
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void updateText(User user) {
        userMapper.updateText(user);
    }

    @Override
    public Address findAddressById(Integer add_id) {
        return userMapper.findAddressById(add_id);
    }

    @Override
    public Address addressByid(Integer id) {
        return userMapper.findByidAddress(id);
    }

    @Override
    public void saveAddress(Address address) {
        userMapper.saveAdress(address);
    }

    @Override
    public User findByIdd(Integer user_id) {
      return userMapper.findById(user_id);
    }
}
