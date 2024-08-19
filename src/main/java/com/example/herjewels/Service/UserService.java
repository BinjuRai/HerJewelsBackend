package com.example.herjewels.Service;

import com.example.herjewels.Entity.User;
import com.example.herjewels.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String save(UserDTO userDTO);
    String update(User user);

    List<User> getAll();

    Optional<User> getById(Integer id);

    Optional<User> getByEmail(String email);

    void deleteById(Integer id);

    boolean validateLogin(String username, String password);

//    Optional<User> getByUsername(String username);


    Optional<User> getByUserDTO(UserDTO userDTO);
}
