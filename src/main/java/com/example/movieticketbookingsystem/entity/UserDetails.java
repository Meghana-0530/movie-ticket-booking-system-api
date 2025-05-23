package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String userId;
        private String username;
        @Column(unique = true)
        private String email;
        private String password;
        private String phoneNumber;
        @Enumerated(value = EnumType.STRING)
        private UserRole userRole;
        private LocalDate dateOfBirth;
        private boolean isDelete;
        private Instant deletedAt;

        @CreatedDate
        private Instant createdAt;
        @LastModifiedDate
        private Instant updatedAt;

}