package com.gustavo.restapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CRUD operations implementation

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {

        Optional<User> result = userRepository.findById(id);
        User user = null;

        if (result.isPresent()){
            user = result.get();
        }
        else {
            throw new RuntimeException("Did not find user id - "+ id);
        }
        return user;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
