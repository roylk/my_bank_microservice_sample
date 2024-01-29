package com.roger.accountservice.models;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Customer {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
}
