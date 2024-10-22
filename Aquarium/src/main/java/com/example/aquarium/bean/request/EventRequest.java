package com.example.aquarium.bean.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Date;

public class EventRequest {

    @NotBlank(message = "Event name is required")
    @Size(max = 100, message = "Event name must not exceed 100 characters")
    private String eventName;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required")
    private LocalDateTime endDate;

    private MultipartFile img;

    private Integer userId;

    public EventRequest() {
    }

    public String getEventName() {
        return eventName;
    }


    public String getDescription() {
        return description;
    }


    public @NotNull(message = "Start date is required") LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull(message = "Start date is required") LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public @NotNull(message = "End date is required") LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotNull(message = "End date is required") LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setEventName(@NotBlank(message = "Event name is required") @Size(max = 100, message = "Event name must not exceed 100 characters") String eventName) {
        this.eventName = eventName;
    }

    public void setDescription(@NotBlank(message = "Description is required") String description) {
        this.description = description;
    }



    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

}

