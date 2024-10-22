package com.example.aquarium.bean.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ImgRequest {
    @NotBlank(message = "Image name is required")
    private String imgName;

    @Size(max = 500, message = "Description can be at most 500 characters")
    private String description;

    public ImgRequest() {
    }

    public @NotBlank(message = "Image name is required") String getImgName() {
        return imgName;
    }

    public void setImgName(@NotBlank(message = "Image name is required") String imgName) {
        this.imgName = imgName;
    }


}

