package com.example.movieticketbookingsystem.mapper;

//import com.example.movieticketbookingsystem.dto.UserResponse;
//import com.example.movieticketbookingsystem.entity.TheaterOwner;
//import com.example.movieticketbookingsystem.entity.User;
//import com.example.movieticketbookingsystem.entity.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.time.Instant;
//
//import static com.example.movieticketbookingsystem.enums.UserRole.THEATER_OWNER;
//import static com.example.movieticketbookingsystem.enums.UserRole.USER;
//

import com.example.movieticketbookingsystem.dto.UserResponse;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;

////@Component
//public class UserDetailsMapper {
//    public UserResponse userDetailsResponseMapper(UserDetails userDetails){
//        if(userDetails == null)
//            return null;
//        return new UserResponse(
//                userDetails.getUserId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                userDetails.getPhoneNumber(),
//                userDetails.getDateOfBirth(),
//                userDetails.getUserRole()
//        );
//
//    }
//}

//@Component
//public class UserDetailsMapper {
//    private UserDetailsMapper() {} // Utility class
////
//    public static UserDetails mapFromDTO(UserResponse dto) {
//        UserDetails user = switch (dto.userRole()) {
//            case USER -> new User();
//            case THEATER_OWNER -> new TheaterOwner();
//        };
//
//        user.setUsername(dto.username());
//        user.setEmail(dto.email());
////        user.setPassword(dto.password()); // Hash later
//        user.setPhoneNumber(dto.phoneNumber());
//        user.setDateOfBirth(dto.dateOfBirth());
//        user.setUserRole(dto.userRole());
//
//        long now = Instant.now().toEpochMilli();
//        user.setCreatedAt(now);
//        user.setUpdatedAt(now);
//
//        return user;
//}
//}
@Component
public class UserDetailsMapper {
    public UserResponse userDetailsResponseMapper(UserDetails userDetails){
        if(userDetails == null)
            return null;
        return new UserResponse(
                //  userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getPhoneNumber(),
                userDetails.getDateOfBirth(),
                userDetails.getUserRole()
        );
    }

}