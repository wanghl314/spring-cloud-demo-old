package com.whl.demo.module.log.vo;

import java.io.Serializable;
import java.util.Date;

public class PostVo implements Serializable {
    private static final long serialVersionUID = 5338450414599423938L;

    private String content;

    private Date datetime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

}
