package com.gustavo.restapi.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0);
        User dbUser = userService.save(user);;
        return dbUser;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.findById(userId);
        if(user == null){
            throw new RuntimeException("User id not found - " + userId);
        }
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {
       User tempUser = userService.findById(userId);

       if(tempUser == null) {
           throw  new RuntimeException("User id not found - " + userId);
       }
       else {
           userService.deleteById(userId);
           return "Deleted user id - " + userId;
       }
    }
}
