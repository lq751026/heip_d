package com.example.heip_d.com.example.bean;

import java.util.Date;

/**
 * 通知
 */
public class Notice {
    /**
     *  标题：title
     *  		内容：content
     * 		图片: img
     */
    private Integer id;
    private String title;
    private String content;
    private String pathimg;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPathimg() {
        return pathimg;
    }

    public void setPathimg(String pathimg) {
        this.pathimg = pathimg;
    }
}
