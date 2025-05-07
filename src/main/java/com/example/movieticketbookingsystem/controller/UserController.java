package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.dto.UserResponse;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.util.ResponseStructure;
import com.example.movieticketbookingsystem.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/user")
//@RestController
//@AllArgsConstructor
//public class UserController {
//    private final UserService userService;
//    private final RestResponseBuilder restResponseBuilder;
//
//    //@PostMapping("/register")
//    //public ResponseEntity<ResponseStructure<UserDetails>> addUser(@RequestBody UserDetails user){
//      UserDetails userDetails = userService.addUser((user));
//    //return  restResponseBuilder.sucess(HttpStatus.OK, "New User Details Has been", userDetails);
//
//
//    }
//}
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserDetails>> addUser(
            @RequestBody UserResponse dto) {

        UserDetails savedUser = userService.addUser(dto);
        return responseBuilder.sucess(HttpStatus.OK, "User registered successfully", savedUser);
    }
}