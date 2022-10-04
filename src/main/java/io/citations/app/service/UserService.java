package io.citations.app.service;

import io.citations.app.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User addNewUser(User user);
    User editUser(User user);
    void deleteUser(Long id);
    User showOnUser(Long id);
    List<User> showAllUser();
}
