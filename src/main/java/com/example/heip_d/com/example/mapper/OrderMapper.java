package com.example.heip_d.com.example.mapper;

import com.example.heip_d.com.example.bean.AddOrder;
import com.example.heip_d.com.example.bean.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    @Select("select * from orders ")
  public List<Orders> findAll();

    @Select("select * from orders where user_id=#{id}")
    List<Orders> findByUserid(Integer id);

    @Delete("delete from orders where order_number=#{id}")
    void delete(String id);

   @Select("select * from orders where taker_id=#{id}")
  List<Orders> findByIDid(Integer id);
    @Select("select * from orders where taker_id=#{userId} and gb_id=#{id}")
    List<Orders> findByDDID(Integer userId, Integer id);

    @Update("update orders set gb_id=2,status_id=1 where order_number=#{number}")
    void updateOrder(String number);

   @Select("select * from orders where order_number=#{number}")
  Orders findNumber(String number);

   @Update("update orders set taker_id=#{id},gb_id=1 where order_number=#{numbe}")
    void grabOrder(String numbe, Integer id);

    /**
     *   private  Integer aid;
     *     private  String text;
     *     private  Integer r_id;
     *     private  Double money;
     *     private Date date;
     * @param addOrder
     *
     */
   @Insert("insert into orders(order_number,user_id,status_id,aid_id,thing,hope_time,moeny,taker_id,pay_id,gb_id,role_id) values(#{uid},#{user_id},2,1,#{text},#{date},#{money},0,#{pay_id},5,#{role_id}) ")
    void addOrder(AddOrder addOrder);
}
