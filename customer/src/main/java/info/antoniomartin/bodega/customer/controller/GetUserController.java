package info.antoniomartin.bodega.customer.controller;

import info.antoniomartin.bodega.customer.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class GetUserController {

    private final Environment environment;

    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") String userId) {
        return User.builder()
            .id(UUID.randomUUID().toString())
            .name("Fake USer")
            .surname("Faker Surname")
            .username(userId)
            .password("ThePassWord")
            .port(Integer.parseInt(environment.getProperty("local.server.port")))
            .build();
    }
}
