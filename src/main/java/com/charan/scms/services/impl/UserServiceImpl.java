package com.charan.scms.services.impl;

import com.charan.scms.entities.User;
import com.charan.scms.helpers.ResourceNotFoundException;
import com.charan.scms.repositories.UserRepository;
import com.charan.scms.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Override
    public User saveUser(User user) {
        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user1=userRepository.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("User not found"));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAbout(user.getAbout());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setProfilePic(user.getProfilePic());
        user1.setEnabled(user.isEnabled());
        user1.setEmailVerified(user.isEmailVerified());
        user1.setPhoneVerified(user.isPhoneVerified());
        user1.setProvider(user.getProvider());
        user1.setProviderUserId(user.getProviderUserId());

        User save=userRepository.save(user1);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user1=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
        userRepository.delete(user1);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user=userRepository.findById(userId).orElse(null);
        return user != null;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user=userRepository.findByEmail(email).orElse(null);
        return user != null;
    }

    @Override
    public List<User> getALlUsers() {
        return userRepository.findAll();
    }
}
