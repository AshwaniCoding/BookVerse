package com.library_management.bookverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_management.bookverse.dao.UserDAO;
import com.library_management.bookverse.model.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> get() {
        return userDAO.get();
    }

    @Transactional
    @Override
    public User get(int user_id) {
        return userDAO.get(user_id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void delete(int user_id) {
        userDAO.delete(user_id);
    }
    
    @Transactional
    @Override
    public User login(String email, String password) {
        User user = userDAO.getByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Transactional
    @Override
    public User getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Transactional
    @Override
    public boolean resetPassword(String email) {
        User user = userDAO.getByEmail(email);
        if (user != null) {
            // Logic to send reset password email or create a reset link
            return true;
        }
        return false;
    }

}
