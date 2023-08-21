package com.socialmedia.project.dto;

//import lombok.Data;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//@Data
@ApiModel(description = "Данные для аутентификации пользователя")
public class LoginDto {

    @ApiParam(value = "Логин пользователя", example = "username")
    private String username;

    @ApiParam(value = "Пароль", example = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
