package com.roger.customerservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Getter @Setter @ToString @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
public class Customer {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=2)
    private String firstName;
    @NotEmpty
    @Size(min=2)
    private String lastName;
    @NotEmpty
    @Size(min=8)
    private String email;
}
