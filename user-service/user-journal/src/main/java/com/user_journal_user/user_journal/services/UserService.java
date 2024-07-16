package com.user_journal_user.user_journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLogRepository userLogRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public User registerUser(User user) {
        User savedUser = userRepository.save(user);
        logUserAction(savedUser.getId(), "User registered");
        kafkaTemplate.send("user-events", "User registered: " + user.getUsername());
        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        User updatedUser = userRepository.save(user);
        logUserAction(id, "User updated");
        return updatedUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        logUserAction(id, "User deleted");
        kafkaTemplate.send("user-events", "User deleted: " + id);
    }

    private void logUserAction(Long userId, String action) {
        UserLog log = new UserLog();
        log.setUserId(userId);
        log.setAction(action);
        log.setTimestamp(LocalDateTime.now().toString());
        userLogRepository.save(log);
    }
}