package com.example.herjewels.Controller;

import com.example.herjewels.Entity.User;
import com.example.herjewels.Service.UserService;
import com.example.herjewels.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController // restful API
@RequestMapping("/user")
@RequiredArgsConstructor // to inject dependency, reduced code
@CrossOrigin(origins = "http://localhost:5173")

public class UserController {

    private final UserService userService;
    //    private final OtpEmailSender otpSender = new OtpEmailSender();
    private final boolean[] emailOtpPassword = {false, false, false};

    @GetMapping("/data")
    public String getData() {
        return "data retrieved";
    }

    @PostMapping("/save")
    public ResponseEntity<String> createData(@RequestBody UserDTO userDTO) {
        try {
            userService.save(userDTO);
            return ResponseEntity.ok("User successfully saved");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving user");
        }
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Integer id) {
        Optional<User> userOptional = userService.getById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {
        Optional<User> userOptional = userService.getByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);
    }

    @PostMapping("/validateLogin")
    public ResponseEntity<String> validateLogin(@RequestBody UserDTO userDTO) {

        System.out.println("Received request with userDTO: " + userDTO);
        // Validate login logic using the userService
        boolean isValidLogin = userService.validateLogin(userDTO.getUsername(), userDTO.getPassword());

        if (isValidLogin) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}