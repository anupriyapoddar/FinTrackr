package com.anupriyap.FinTrackr.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Indexed(unique = true)   // email should be unique and no duplicates
    private String email;

    private String password;

    private Role role;

    private boolean active;

    private String otp;
}