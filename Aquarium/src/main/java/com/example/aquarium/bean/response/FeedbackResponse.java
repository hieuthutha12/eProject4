package com.example.aquarium.bean.response;

import java.time.LocalDateTime;

public class FeedbackResponse {
    private String content;
    private LocalDateTime date;
    private String fullName;

    public FeedbackResponse() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }
}
