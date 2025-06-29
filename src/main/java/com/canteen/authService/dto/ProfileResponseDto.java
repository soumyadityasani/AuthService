package com.canteen.authService.dto;

import com.canteen.authService.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponseDto {

    private String username;
    private String collegeRoll;
    private String email;
    private String contact;
    private RoleEnum role;


}