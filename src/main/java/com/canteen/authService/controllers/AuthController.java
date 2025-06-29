package com.canteen.authService.controllers;

import com.canteen.authService.dto.*;
import com.canteen.authService.services.AuthService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResonseDto<SignUpResponseDto>> registerUser( @Valid @RequestBody SignUpRequestDto requestDto){
        return authService.registerUser(requestDto);
    }

    @GetMapping("/verify-email-link")
    public ResponseEntity<String> sendEmail(@RequestParam @Email @Size(max = 50, message = "MAX 50 DIGIT") String email) throws IOException {
        return authService.sentVerifyEmail(email);
    }

    @PostMapping("/verify-email-link")
    public ResponseEntity<ApiResonseDto<VerificationResponseDto>> verifyEmail(@RequestParam @Size(max=36 ,message = "MAX 36 CHARACTER") String token){
        return authService.verifyEmail(token);
    }

    @GetMapping("/verify-email-code")
    public ResponseEntity<?> sendEmailCode(@RequestParam @Email @Size(max = 50, message = "MAX 50 DIGIT") String email){
        return authService.sendOtpToEmail(email);
    }

    @PostMapping("/verify-email-code")
    public ResponseEntity<?> verifyEmailCode(@RequestParam @Email @Size(max = 50, message = "MAX 50 DIGIT") String email, @RequestParam @Size(max=6 ,message = "MAX 6 CHARACTER") String code){
        return authService.verifyEmailOtp(email,code);
    }

    @PostMapping("/sent-otp")
    public ResponseEntity<String> sentOtp(@RequestParam @Size(max = 10, message = "MAX 10 DIGIT") String contact){
        return authService.sendOtpToContact(contact);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<ApiResonseDto<VerificationResponseDto>> verifyOtp(@RequestParam @Size(max = 10, message = "MAX 10 DIGIT") String contact, @RequestParam @Size(max=6 ,message = "MAX 6 CHARACTER") String otp){
        return authService.verifyContactOtp(contact, otp);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResonseDto<LoginResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto){
        return authService.loginUser(requestDto);
    }

    @GetMapping("/profile")
    public ResponseEntity<ProfileResponseDto> getCurrentUserProfile(Authentication auth){
        return authService.profileUser(auth);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateUserResponseDto> updateUserProfile( @Valid @RequestBody UpdateUserRequestDto requestDto,Authentication authentication){
        return authService.updateUser(requestDto,authentication);
    }

    @PutMapping("/change-password")
    public ResponseEntity<ChangePasswordResponseDto> changePassword(@RequestBody ChangePasswordRequestDto requestDto, Authentication auth){
        return authService.changePassword(requestDto.getPassword(),requestDto.getNewPassword(),auth);
    }

    @PutMapping("/forgot-password-email")
    public ResponseEntity<String> forgotPassword(@RequestParam @Email @Size(max = 50, message = "MAX 50 DIGIT") String email){
        return authService.forgotPasswordEmail(email);
    }

}
