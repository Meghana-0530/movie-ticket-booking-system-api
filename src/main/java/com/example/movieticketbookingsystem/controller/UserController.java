package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.util.ResponseStructure;
import com.example.movieticketbookingsystem.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {

        private final UserService userService;
        private final RestResponseBuilder restResponseBuilder;

        @PostMapping("/register")
        public ResponseEntity<ResponseStructure<UserDetails>> addUser(@RequestBody UserDetails user){
            UserDetails userDetails = userService.addUser((user));
            return  restResponseBuilder.sucess(HttpStatus.OK, "New User Details Has been", userDetails);
        }


    }
