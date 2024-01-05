package com.AMS.serviceuser.service;

import com.AMS.serviceuser.model.User;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    //public JSONObject findAll();
    public List<User> findAll();
    public Optional<User> getById(Long userId);
    public User create(User userData);
    public User update(Long userId, User updatedUserData);
    public void delete(Long userId);
    public Optional<User> autenticarUsuario(String name, String password);
}
