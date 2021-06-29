package com.example.bookshop.controller;

import com.example.bookshop.configuration.CustomExceptionHandler;
import com.example.bookshop.entity.User;
import com.example.bookshop.exceptions.UserException;
import com.example.bookshop.exceptions.book_service_exceptions.UserNotFoundException;
import com.example.bookshop.models.ResultMessage;
import com.example.bookshop.models.UserForSave;
import com.example.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CustomExceptionHandler
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<ResultMessage> createUser(@RequestBody UserForSave userForSave) throws UserException {
        var user = userForSave.convertToUser();
        user.setPassword(passwordEncoder.encode(userForSave.getPassword()));
        userService.addUser(user);
        return ResponseEntity.ok(new ResultMessage());
    }

    @PostMapping("/add_money")
    public ResponseEntity<ResultMessage> addMoney(@RequestBody UserForSave userForSave) throws UserException{
        userService.addMoneyToUser(userForSave);
        return ResponseEntity.ok(new ResultMessage());
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(name));
    }

    @GetMapping("/get_all")
    public List<User> getAll(){
        return userService.getAll();
    }

}
