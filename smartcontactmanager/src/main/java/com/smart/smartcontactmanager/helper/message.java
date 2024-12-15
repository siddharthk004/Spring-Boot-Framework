package com.smart.smartcontactmanager.helper;

public class message {
    private String Content;
    private String type;
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public message(String content, String type) {
        Content = content;
        this.type = type;
    }
}
