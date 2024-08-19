package com.example.herjewels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForgetPasswordDTO {
    @NotNull
    private String email;

    private String otp;

    private String password;
}
