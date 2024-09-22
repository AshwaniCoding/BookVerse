package com.library_management.bookverse.dao;

import java.util.List;
import com.library_management.bookverse.model.User;

public interface UserDAO {

    List<User> get();

    User get(int user_id);

    void save(User user);

    void delete(int user_id);
    
    User getByEmail(String email);

}
