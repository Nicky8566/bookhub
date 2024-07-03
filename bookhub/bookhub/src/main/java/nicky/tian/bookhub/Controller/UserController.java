package nicky.tian.bookhub.Controller;

import nicky.tian.bookhub.Entity.User;
import nicky.tian.bookhub.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.get_id();
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        Optional<User> foundUser = userService.getUserByEmail(user.getEmail());
        if (foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }
}