package io.kaminin.petproject.controller;

import io.kaminin.petproject.model.User;
import io.kaminin.petproject.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Api(tags = {"Пользователи"})
public class UserController {
    private final UserService userService;

    @Operation(summary = "Получить всех пользователей")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Получить пользователя")
    @GetMapping
    public ResponseEntity<User> getUserById(
            @ApiParam(value = "Идентификатор пользователя", required = true) @RequestParam Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Создать пользователя")
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Редактировать пользователя")
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User newUser = userService.updateUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping
    public ResponseEntity<?> deleteUser(
            @ApiParam(value = "Идентификатор пользователя", required = true) @RequestParam Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
