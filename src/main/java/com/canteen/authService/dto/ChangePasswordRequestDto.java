package com.canteen.authService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangePasswordRequestDto {

    @NotBlank(message = "PASSWORD IS REQUIRE")
    @Size(max=12, message = "MAX 12 CHARACTERS")
    private String password;

    @NotBlank(message = "CONFIRM PASSWORD IS REQUIRE")
    @Size(max=12, message = "MAX 12 CHARACTERS")
    private String newPassword;
}
