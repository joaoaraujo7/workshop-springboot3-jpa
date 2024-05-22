package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entitites.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        User user = findById(id);
        try {
            userRepository.delete(user);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User updateUser(Integer userId, User newUser) {
        User existingUser = userRepository.getReferenceById(userId);
        updateData(existingUser, newUser);
        return saveUser(existingUser);
    }

    private void updateData(User existingUser, User newUser) {
        existingUser.setName(newUser.getName());
        existingUser.setEmail(newUser.getEmail());
        existingUser.setPhone(newUser.getPhone());
    }


}
