package com.zxl.repository;

import com.zxl.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public String findtype(String id,String password);
    public void updatepassword(String password,String id);
    public User findbyid(String id);
    public void delete(String id);
    public void insert(User user);
}
