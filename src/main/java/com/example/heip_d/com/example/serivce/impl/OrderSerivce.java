package com.example.heip_d.com.example.serivce.impl;

import com.example.heip_d.com.example.bean.*;
import com.example.heip_d.com.example.mapper.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class OrderSerivce {
    @Autowired
    private UserMapper userMapper;
 @Autowired
    private OrderMapper orderMapper;
 @Autowired
 private AidMapper aidMapper;
  @Autowired
  private StatusMapper statusMapper;
  @Autowired
    private BountyMapper bountyMapper;
  @Autowired
  private GrabMapper grabMapper;
  @Autowired
  private  PayMapper payMapper;
  public List<Orders> findAll(Integer page, Integer size){
       PageHelper.startPage(page,size);
       return orderMapper.findAll();
   }

    public List<Orders> findByUserid(Integer id, User user, Integer integer) {
        /**
         *
         */
      String [] sub={"","待付款","待抢单","进行中","已完成"};
        List<Orders> orders = orderMapper.findByUserid(id);
        for (Orders order : orders) {
            Bounty byId = bountyMapper.findById(user.getB_id());
            Aid aid = aidMapper.findById(order.getAid_id());
            Status status=null;
            if(integer!=null&&integer!=0){
                status =statusMapper.findBsyId(order.getStatus_id(),sub[integer]);
            }else {
                 status = statusMapper.findById(order.getStatus_id());
            }
            if(status!=null){
                order.setStatus(status);
            }
            order.setBounty(byId);
            order.setAid(aid);
        }
        return orders;
     }

    public void delete(String id) {
     orderMapper.delete(id);
  }

    public List<Orders> findByiD(Integer userId, Integer id) {
        List<Orders> orders=null;
        if(id!=0){
             orders=orderMapper.findByDDID(userId,id);

        }else{
            orders = orderMapper.findByIDid(userId);

        }
        for (Orders order : orders) {
            User user = userMapper.findById(order.getUser_id());
            Bounty byId = bountyMapper.findById(user.getB_id());
            Grab grab=null;
            Aid aid = aidMapper.findById(order.getAid_id());
            grab = grabMapper.findById(order.getGb_id());
            order.setGrab(grab);
            order.setUser(user);
            order.setAid(aid);
            order.setBounty(byId);
        }

        return orders;
    }

    public void updateOrder(String number) {
        orderMapper.updateOrder(number);
    }

    public Orders findNumber(String number) {

       return orderMapper.findNumber(number);
  }

    public void grabOrder(String numbe,Integer id, Integer user_id) {
        Orders orders = orderMapper.findNumber(numbe);
        payMapper.updateHelpId(user_id,orders.getPay_id());
     orderMapper.grabOrder(numbe,id);
  }

    public void addOrder(AddOrder addOrder, HttpServletResponse response) throws IOException {
          payMapper.insert(addOrder.getUser_id());
        List<Pay> pay=payMapper.findByUser_id(addOrder.getUser_id());
          addOrder.setPay_id(pay.get(0).getId());
          if(pay.size()>1){
              response.getWriter().println("当前已经已发布订单请你等着完成在发布!<a href='/orders?id=0'>返回我的发布中心</a>");

          }else{
              orderMapper.addOrder(addOrder);
          }

    }

}
