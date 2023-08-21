package com.socialmedia.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

@ApiModel(description = "Данные для регистрации пользователя")
public class SignUpDto {

    @ApiParam(value = "Логин пользователя", example = "username")
    private String username;

    @ApiParam(value = "Электронная почта", example = "username@mail.ru")
    private String email;

    @ApiParam(value = "Пароль", example = "password")
    private String password;

    public SignUpDto() {
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
