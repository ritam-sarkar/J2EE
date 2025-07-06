package client;

import org.springframework.web.reactive.function.client.WebClient;
import webflux.netty.model.User;

import java.util.concurrent.CountDownLatch;

public class UserClientApp {
    private static final WebClient client = WebClient.builder()
            .baseUrl("http://localhost:8080/user")
            .build();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        createUser(new User("Charlie", 40), latch);
        createUser(new User("Bob", 45), latch);
        getAllUsers(latch);
        getUserByName("Charlie", latch);
        getUserByName("Ritam", latch);

        // Wait for all async tasks to complete
        latch.await();
    }

    private static void createUser(User user, CountDownLatch latch) {
        client.post()
                .uri("/create")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(User.class)
                .subscribe(
                        u -> {
                            System.out.println("✅ Created user: " + u.getName());
                            latch.countDown();
                        },
                        error -> {
                            System.err.println("❌ Error creating user: " + error.getMessage());
                            latch.countDown();
                        }
                );
    }

    private static void getAllUsers(CountDownLatch latch) {
        client.get()
                .uri("/allUsers")
                .retrieve()
                .bodyToFlux(User.class)
                .doOnComplete(latch::countDown)
                .subscribe(
                        user -> System.out.println("👤 User: " + user.getName() + ", Age: " + user.getAge()),
                        error -> {
                            System.err.println("❌ Error fetching users: " + error.getMessage());
                            latch.countDown();
                        }
                );
    }

    private static void getUserByName(String name, CountDownLatch latch) {
        client.get()
                .uri("/{name}", name)
                .retrieve()
                .bodyToMono(User.class)
                .subscribe(
                        user -> {
                            System.out.println("🔍 Found user: " + user.getName());
                            latch.countDown();
                        },
                        error -> {
                            System.err.println("❌ Error finding user: " + error.getMessage());
                            latch.countDown();
                        }
                );
    }
}
