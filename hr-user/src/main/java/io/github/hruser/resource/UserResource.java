package io.github.hruser.resource;

import io.github.hruser.entity.User;
import io.github.hruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        User user = repository.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> searchByEmail(@RequestParam String email) {
        User user = repository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
