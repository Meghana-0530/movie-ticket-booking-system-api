package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.entity.TheatreOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.exceptions.UserExistsByEmailException;
import com.example.movieticketbookingsystem.exceptions.UserExistsByEmailException;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.enums.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
    public class UserServiceImpl implements UserService {
        private final UserRepository userRepository;
        @Override
        public UserDetails addUser(UserDetails user) {
            if(! userRepository.existsByEmail(user.getEmail())) {
                // return  copy(user);
                return switch (user.getUserRole()) {
                    case USER -> copy(new User(), user);
                    case THEATRE_OWNER -> copy(new TheatreOwner(), user);


                };
            }
            throw new UserExistsByEmailException("User with the Email is already exits");
        }
        private UserDetails copy(UserDetails userRole, UserDetails user) {
            //User details userRole = user.getUserRole()==UserRole.USER ? new User() : new TheatreOwner();
            userRole.setUserRole(user.getUserRole());
            userRole.setEmail(user.getEmail());
            userRole.setPassword(user.getPassword());
            userRole.setCreatedAt(user.getCreatedAt());
            userRole.setDateOfBirth(user.getDateOfBirth());
            userRole.setPhoneNumber(user.getPhoneNumber());
            userRole.setUsername(user.getUsername());
            userRole.setUpdatedAt(user.getUpdatedAt());
            userRepository.save(userRole);
            return userRole;
    }
}
