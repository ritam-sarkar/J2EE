package webflux.netty;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.netty.exception.UserNotFoundException;
import webflux.netty.model.User;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final ConcurrentHashMap<String, User> userStore = new ConcurrentHashMap<>();

    public Flux<User> getAllUsers() {
        return Flux.fromIterable(userStore.values());
    }

    public Mono<User> getUserByName(String name) {
        User user = userStore.get(name);
        if (user == null) {
            return Mono.error(new UserNotFoundException("User not found: " + name));
        }
        return Mono.just(user);
    }

    public Mono<User> createUser(User user) {
        userStore.put(user.getName(), user);
        return Mono.just(user);
    }
}

