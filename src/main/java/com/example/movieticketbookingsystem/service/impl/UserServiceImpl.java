package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.UserResponse;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.exceptions.UserExistByEmailException;
import com.example.movieticketbookingsystem.mapper.UserDetailsMapper;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Transactional
    @Override
    public UserDetails addUser(UserResponse dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new UserExistByEmailException("User with email already exists");
        }

        UserDetails user = UserDetailsMapper.mapFromDTO(dto);
        return userRepository.save(user);
    }
}