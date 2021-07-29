package io.kaminin.petproject.service;

import io.kaminin.petproject.exception.UserNotFoundException;
import io.kaminin.petproject.model.User;
import io.kaminin.petproject.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * UserService Class
 *
 * @author r.kaminin
 * @version 17.07.2021
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepo userRepo;

    public User addUser(User user) {
        user.setCode(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteUserById(id);
    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
}
