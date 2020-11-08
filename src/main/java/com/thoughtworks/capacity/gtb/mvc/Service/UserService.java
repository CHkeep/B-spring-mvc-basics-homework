package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameExistsException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameOrPasswordExistsException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    public void postUser(User user){
        if(userMap.containsKey(user.getUserName())){
            throw new UserNameExistsException("用户已存在");
        }
        userMap.put(user.getUserName(), user);
    }

    public User getUser(String userName, String password) {
        if(!(userMap.containsValue(userName) && password.equals(userMap.get(userName).getPassword()))){
            throw new UserNameOrPasswordExistsException("用户名或密码错误");
        }
        return userMap.get(userName);
    }
}
