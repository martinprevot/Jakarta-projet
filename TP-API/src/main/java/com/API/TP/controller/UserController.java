package com.API.TP.controller;

import com.API.TP.DTO.CreateUserDto;
import com.API.TP.DTO.UpdateUserDto;
import com.API.TP.model.User;
import com.API.TP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User inconnu " + id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User inconnu " + id));
        user.setNom(updateUserDto.getNom());
        user.setEmail(updateUserDto.getEmail());
        user.setMotDePasse(updateUserDto.getMotDePasse());
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
