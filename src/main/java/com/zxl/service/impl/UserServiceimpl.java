package com.zxl.service.impl;

import com.zxl.entity.User;
import com.zxl.repository.UserRepository;
import com.zxl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String findtype(String id, String password) {
        return userRepository.findtype(id, password);
    }

    @Override
    public void updatepassword(String password, String id) {
        userRepository.updatepassword(password,id);
    }

    @Override
    public User findbyid(String id) {
        return userRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }


    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

}
