package com.example.heip_d.com.example.bean;
//实名认证
public class Approve {
  private Integer id;
  private String name;
  private String path_img;
    private Integer code;
  private String student_id;
  private Integer user_id;

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    private String codeString;

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





    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeString() {
        if(code!=null){
            String var=null;
          switch (code){
              case 0:var="未实名";break;
              case 1:var="审核中";break;
              case 2:var="已实名";break;
          }
           this.codeString=var;
        }
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }
}
