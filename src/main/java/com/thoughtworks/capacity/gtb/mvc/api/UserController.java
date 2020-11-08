package com.thoughtworks.capacity.gtb.mvc.api;


import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class UserController {
    private  final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity postUser(@RequestBody @Valid User user){
        return userService.postUser(user);
    }

    @GetMapping("/login")
    public ResponseEntity<User> getUser(@RequestParam @Pattern(regexp = "\\w{3,10}", message = "用户名不合法") String userName, @RequestParam @Pattern(regexp = ".{5,12}", message = "密码不合法") String password){
        return  userService.getUser(userName, password);
    }

}
