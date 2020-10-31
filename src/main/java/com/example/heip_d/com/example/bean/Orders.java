package com.example.heip_d.com.example.bean;

import org.omg.PortableInterceptor.INACTIVE;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Orders {
  private String order_number;
  private Integer user_id;             //用户id
  private Integer status_id;       //状态id
    private Integer aid_id;
    private Aid aid;
   private User user;
   private Status status;
   private String thing;
   private Date hope_time;
   private Bounty bounty;
   private Integer gb_id;
   private Grab grab;
   private Integer pay_id;
   private Integer taker_id;
   private Double moeny;
   private Integer role_id;
    private Role  role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Double getMoeny() {
        return moeny;
    }

    public void setMoeny(Double moeny) {
        this.moeny = moeny;
    }

    public Integer getTaker_id() {
        return taker_id;
    }

    public void setTaker_id(Integer taker_id) {
        this.taker_id = taker_id;
    }

    public Integer getPay_id() {
        return pay_id;
    }

    public void setPay_id(Integer pay_id) {
        this.pay_id = pay_id;
    }

    public Grab getGrab() {
        return grab;
    }

    public void setGrab(Grab grab) {
        this.grab = grab;
    }

    public Integer getGb_id() {
        return gb_id;
    }

    public void setGb_id(Integer gb_id) {
        this.gb_id = gb_id;
    }

    public Bounty getBounty() {
        return bounty;
    }

    public void setBounty(Bounty bounty) {
        this.bounty = bounty;
    }

    public Date getHope_time() {
        return hope_time;
    }

    public void setHope_time(Date hope_time) {
        this.hope_time = hope_time;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAid_id() {
        return aid_id;
    }

    public void setAid_id(Integer aid_id) {
        this.aid_id = aid_id;
    }

    public Aid getAid() {
        return aid;
    }

    public void setAid(Aid aid) {
        this.aid = aid;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }
}
