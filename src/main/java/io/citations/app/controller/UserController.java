package io.citations.app.controller;

import io.citations.app.entity.User;
import io.citations.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User addNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @PatchMapping("/")
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        if(userService.showOnUser(id)==null){
            return "USER NOT FOUND";
        }else{
            userService.deleteUser(id);
            return "USER SUCCESS DELETE";
        }
    }

    @GetMapping("/{id}")
    public User showOnUser(@PathVariable Long id){
        return userService.showOnUser(id);
    }

    @GetMapping("/")
    public List<User> showAllUsers(){
        return userService.showAllUser();
    }

}
