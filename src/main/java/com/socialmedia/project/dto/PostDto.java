package com.socialmedia.project.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

@ApiModel(description = "Данные для операций над постом")
public class PostDto {

    @ApiParam(value = "Заголовок", example = "Заголовок поста")
    private String title;

    @ApiParam(value = "Текст", example = "Текст поста")
    private String text;
    //public byte[] image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //public byte[] getImage() {
        //return image;
    //}

    //public void setImage(byte[] image) {
        //this.image = image;
    //}
}
