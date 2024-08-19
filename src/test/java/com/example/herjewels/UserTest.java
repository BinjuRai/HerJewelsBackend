package com.example.herjewels;

import com.example.herjewels.Entity.User;
import com.example.herjewels.Service.Impl.UserServiceImpl;
import com.example.herjewels.dto.UserDTO;
import com.example.herjewels.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



import static org.mockito.Mockito.when;

public class UserTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testUser");
        userDTO.setEmail("test@example.com");

        when(userRepository.save(any(User.class))).thenReturn(new User());

        String result = userService.save(userDTO);

        assertEquals("Success", result);
    }
}
