package com.anupriyap.FinTrackr.repository;

import com.anupriyap.FinTrackr.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
}
