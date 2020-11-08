package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "用户名不为空")
    @Pattern(regexp = "\\w{3,10}", message = "用户名不合法")
    private String userName;
    @Pattern(regexp = ".{5,12}", message = "密码不合法")
    @NotNull(message = " 密码是不为空")
    private String password;
    @Email(message = "邮箱地址不合法")
    private String email;
}
