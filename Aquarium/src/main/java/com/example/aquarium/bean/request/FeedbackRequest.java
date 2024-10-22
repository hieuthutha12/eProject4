package com.example.aquarium.bean.request;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public class FeedbackRequest {

    @NotBlank(message = "Content is mandatory")
    private String content;

    private Integer userId;

    public FeedbackRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

