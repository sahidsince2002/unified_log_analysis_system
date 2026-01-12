
package com.hdfc.log.hdfc.service;

import com.hdfc.log.hdfc.entity.User;
import com.hdfc.log.hdfc.exception.DuplicateEmail;
import com.hdfc.log.hdfc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(User user) {

        // ✅ Duplicate email check
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateEmail("Email already exists");
        }

        return userRepository.save(user);
    }
}
