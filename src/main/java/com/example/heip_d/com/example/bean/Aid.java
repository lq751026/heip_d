package com.example.heip_d.com.example.bean;

/**
 * 求助内容表：
 */
public class Aid {
    private Integer id;
    private  String  text;
    private String pathimg;

    public String getPathimg() {
        return pathimg;
    }

    public void setPathimg(String pathimg) {
        this.pathimg = pathimg;
    }

    public String getPath_html() {
        return path_html;
    }

    public void setPath_html(String path_html) {
        this.path_html = path_html;
    }

    private String path_html;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
