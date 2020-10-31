package com.example.heip_d.com.example.bean;
//付款
public class Pay {
     private Integer id;
     private Integer user_id;
     private Integer help_id;
     private Integer pay_code;
     private String pay_img;

    public Integer getPay_code() {
        return pay_code;
    }

    public void setPay_code(Integer pay_code) {
        this.pay_code = pay_code;
    }

    public String getPay_img() {
        return pay_img;
    }

    public void setPay_img(String pay_img) {
        this.pay_img = pay_img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getHelp_id() {
        return help_id;
    }

    public void setHelp_id(Integer help_id) {
        this.help_id = help_id;
    }
}
