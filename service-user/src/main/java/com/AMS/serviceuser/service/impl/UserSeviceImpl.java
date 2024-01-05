package com.AMS.serviceuser.service.impl;

import com.AMS.serviceuser.model.User;
import com.AMS.serviceuser.repository.UserRepository;
import com.AMS.serviceuser.service.UserService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserSeviceImpl implements UserService {

    @Autowired
    UserRepository repository;


    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Optional<User> getById(Long userId) {
        Optional<User> userOptional = repository.findById(userId);
        return userOptional;
    }

    @Override
    public User create(User userData) {
        User newUser = new User();
        newUser.setPassword(userData.getPassword());
        newUser.setName(userData.getName());
        newUser.setEmail(userData.getEmail());
        newUser.setRole(userData.getRole());
        User savedUser = repository.saveAndFlush(newUser);
        return savedUser;
    }

    @Override
    public User update(Long userId, User updatedUserData) {
        Optional<User> existingUserOptional = repository.findById(userId);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(updatedUserData.getName());
            existingUser.setEmail(updatedUserData.getEmail());
            existingUser.setRole(updatedUserData.getRole());
            existingUser.setPassword(updatedUserData.getPassword());

            User updatedUser = repository.save(existingUser);
            return updatedUser;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public Optional<User> autenticarUsuario(String name, String password) {
        return repository.findByNameAndPassword(name, password);
    }
}
