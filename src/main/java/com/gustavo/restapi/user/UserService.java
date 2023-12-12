package com.gustavo.restapi.user;

import java.util.List;

public interface UserService {
    // CRUD Operations: Create, Read, Update, Delete

    User save(User user);

    User findById(int id);

    List<User> findAll();

    void deleteById(int id);
}
