package com.zxl.service;

import com.zxl.entity.User;

public interface UserService {
    public String findtype(String id,String password);
    public void updatepassword(String password,String id);
    public User findbyid(String id);
    public void delete(String id);
    public void insert(User user);
}
