package webflux.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.netty.model.User;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/allUsers")
    public Flux<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{name}")
    public Mono<User> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
}
