package com.example.heip_d.com.example.bean;

import java.util.Date;

/**
 * 用户表
 */
public class User {
    private Integer id;
    private String name;
    private String user_password;
    private Integer b_id;
    private Integer s_id;
    private Integer r_id;
    private String sex;
    private String phone;
    private Date time;
    private Double money;
    private Date hope_time;
    private String tou_img;
    private Bounty bounty;
    private Status status;
    private Role role;
    private String thing;
    private String email;
    private Integer code;
    private String authentication; //通过uuid随机生成的激活码
    private Integer add_id;
    private String address;
    private  String pay_Number;
    private String qq;



    public String getQq() {
        if (email!=null&&!email.equals("")){
            this.qq=email.substring(0,email.indexOf("@"));
        }
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPay_Number() {
        return pay_Number;
    }

    public void setPay_Number(String pay_Number) {
        this.pay_Number = pay_Number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAdd_id() {
        return add_id;
    }

    public void setAdd_id(Integer add_id) {
        this.add_id = add_id;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public Bounty getBounty() {
        return bounty;
    }

    public void setBounty(Bounty bounty) {
        this.bounty = bounty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getTou_img() {
        return tou_img;
    }

    public void setTou_img(String tou_img) {
        this.tou_img = tou_img;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getHope_time() {
        return hope_time;
    }

    public void setHope_time(Date hope_time) {
        this.hope_time = hope_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
