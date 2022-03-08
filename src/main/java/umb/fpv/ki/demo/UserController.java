package umb.fpv.ki.demo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userServices){
        this.userService = userServices;
    }


    @GetMapping("/api/Users")
    public List<UserDto> getUsers(@RequestParam(required = false) String userlName){
        return userService.getUsers(userlName);
    }

    @GetMapping("/api/UserId")
    public List<UserDto> getUsersId(@RequestParam(required = false) String userId){
        return userService.getUserId(userId);
    }

    @PostMapping("/api/Users")
    public String createUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @DeleteMapping("/api/Users/{UserId}")
    public void deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/api/Users/{UserId}")
    public void putUser(@PathVariable Integer userId, @RequestBody UserDto user){
        userService.putUser(userId, user);
    }
}