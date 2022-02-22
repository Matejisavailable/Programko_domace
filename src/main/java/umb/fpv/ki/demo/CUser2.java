package umb.fpv.ki.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CUser2{
    List<User> users;

    public CUser2(){
        this.users = callU();
    }

    public List<User> callU(){
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId("1");
        user1.setfName("Boris");
        user1.setlName("Kolár");
        user1.setEmail("vela.potomkov@gmail.com");
        users.add(user1);

        User user2 = new User();
        user2.setId("2");
        user2.setfName("Robo");
        user2.setlName("Kazik");
        user2.setEmail("topspevak@gmail.com");
        users.add(user2);

        User user3 = new User();
        user3.setId("3");
        user3.setfName("Bob");
        user3.setlName("Bobovec");
        user3.setEmail("bober@gmail.com");
        users.add(user3);

        return users;
    }

    @GetMapping("/api/Users")
    public List<User> getUsers(@RequestParam(required = false) String userlName){
        if (userlName == null){
            return this.users;
        }

        List<User> fUsers = new ArrayList<>();

        for (User user : users){
            if (user.getlName().equals(userlName)){
                fUsers.add(user);
            }
        }

        return fUsers;
    }

    @GetMapping("/api/UserId")
    public List<User> getUsersId(@RequestParam(required = false) String userId){
        if (userId == null){
            return this.users;
        }

        List<User> fUsers = new ArrayList<>();

        for (User user : users){
            if (user.getId().equals(userId)){
                fUsers.add(user);
            }
        }

        return fUsers;
    }

    @PostMapping("/api/Users")
    public List<User> createUser(@RequestBody User user){
        this.users.add(user);

        return users;
    }

    @DeleteMapping("/api/Users/{UserId}")
    public void deleteUser(@PathVariable Integer userId){
        this.users.remove(this.users.get(userId));
    }

    @PutMapping("/api/Users/{UserId}")
    public List<User> putUser(@PathVariable Integer userId, @RequestBody User user){
        this.users.get(userId).setId(user.getId());
        this.users.get(userId).setfName(user.getfName());
        this.users.get(userId).setlName(user.getlName());
        this.users.get(userId).setEmail(user.getEmail());
        return users;
    }
}