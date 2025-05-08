package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.dto.UserResponse;
import com.example.movieticketbookingsystem.dto.UserUpdationRequest;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.exceptions.UserExistByEmailException;
import com.example.movieticketbookingsystem.exceptions.UserNotFoundByEmailException;
import com.example.movieticketbookingsystem.mapper.UserDetailsMapper;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

//@Service
//@AllArgsConstructor
//public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//    @Override
//    public UserDetails addUser(UserDetails user) {
//        if(! userRepository.existsByEmail(user.getEmail())) {
//            // return  copy(user);
//            return switch (user.getUserRole()) {
//                case USER -> copy(new User(), user);
//                case THEATER_OWNER -> copy(new TheaterOwner(), user);
//
//
//            };
//        }
//        throw new UserExistByEmailException("User with the Email is already exits");
//   }
//   private UserDetails copy(UserDetails userRole, UserDetails user) {
//       //User details userRole = user.getUserRole()==UserRole.USER ? new User() : new TheatreOwner();
//       userRole.setUserRole(user.getUserRole());
//       userRole.setEmail(user.getEmail());
//       userRole.setPassword(user.getPassword());
//       userRole.setCreatedAt(user.getCreatedAt());
//       userRole.setDateOfBirth(user.getDateOfBirth());
//       userRole.setPhoneNumber(user.getPhoneNumber());
//       userRole.setUsername(user.getUsername());
//       userRole.setUpdatedAt(user.getUpdatedAt());
//       userRepository.save(userRole);
//       return user;//
//   }
//}
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsMapper userMapper;

    @Override
    public UserResponse addUser(UserRegistrationRequest user) {
        if (userRepository.existsByEmail(user.email()))
            throw new UserExistByEmailException("User with the Email is already exists");

        UserDetails userDetails = switch (user.userRole()) {
            case USER -> copy(new User(), user);
            case THEATER_OWNER -> copy(new TheaterOwner(), user);
        };
        return userMapper.userDetailsResponseMapper(userDetails);

    }
    @Override
    public UserResponse softDeleteUser(String email) {
        if (userRepository.existsByEmail(email)) {
            UserDetails user = userRepository.findByEmail(email);
            user.setDelete(true);
            user.setDeletedAt(Instant.now());
            userRepository.save(user);
            return userMapper.userDetailsResponseMapper(user);
        }
        throw new UserNotFoundByEmailException("Email not found in the Database");
    }



    @Override
    public UserResponse editUser(UserUpdationRequest userRequest, String email) {
        if (userRepository.existsByEmail(email)){
            UserDetails user = userRepository.findByEmail(email);

//            if( userRepository.existsByEmail(userRequest.email()))
//                throw new UserExistByEmailException("User with the email already exists");

            user = copy(user, userRequest);

            return userMapper.userDetailsResponseMapper(user);
        }

        throw new UserNotFoundByEmailException("Email not found in the Database");

    }

    private UserDetails copy(UserDetails userRole, UserRegistrationRequest user) {
        userRole.setUserRole(user.userRole());
        userRole.setPassword(user.password());
        userRole.setEmail(user.email());
        userRole.setDateOfBirth(user.dateOfBirth());
        userRole.setPhoneNumber(user.phoneNumber());
        userRole.setUsername(user.username());
        userRole.setDelete(false);
        userRepository.save(userRole);
        return userRole;
    }

    private UserDetails copy(UserDetails userRole, UserUpdationRequest user) {
        userRole.setUsername(user.username());
        userRole.setDelete(false);
//        userRole.setEmail(user.email());
        userRole.setPhoneNumber(user.phoneNumber());
        userRole.setDateOfBirth(user.dateOfBirth());



        userRepository.save(userRole);
        return userRole;
    }
}