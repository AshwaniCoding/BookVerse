package com.library_management.bookverse.service;

import java.util.List;
import com.library_management.bookverse.model.User;

public interface UserService {

    List<User> get();

    User get(int user_id);

    void save(User user);

    void delete(int user_id);
    
    User login(String email, String password);
    
    User getByEmail(String email);
    
    boolean resetPassword(String email);

}
