package umb.fpv.ki.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CUser2{
    private List<User> users;
    private UserServices userServices;
    public CUser2(UserServices userServices){
        this.userServices = userServices;
    }


    @GetMapping("/api/Users")
    public List<User> getUsers(@RequestParam(required = false) String userlName){
        return this.userServices.getUsers(userlName);
    }

    @GetMapping("/api/UserId")
    public List<User> getUsersId(@RequestParam(required = false) String userId){
        return this.userServices.getUsersId(userId);
    }

    @PostMapping("/api/Users")
    public List<User> createUser(@RequestBody User user){
        return userServices.createUser(user);
    }

    @DeleteMapping("/api/Users/{UserId}")
    public void deleteUser(@PathVariable Integer userId){
        this.userServices.deleteUser(userId);
    }

    @PutMapping("/api/Users/{UserId}")
    public List<User> putUser(@PathVariable Integer userId, @RequestBody User user){
        return this.userServices.putUser(userId, user);
    }
}