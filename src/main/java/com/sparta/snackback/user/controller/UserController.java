package com.sparta.snackback.user.controller;

import com.sparta.snackback.common.dto.SendMessageDto;
import com.sparta.snackback.user.dto.LoginRequestDto;
import com.sparta.snackback.user.dto.LoginResponseDto;
import com.sparta.snackback.user.dto.SignupRequestDto;
import com.sparta.snackback.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<SendMessageDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }

    // 로그인
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return userService.login(loginRequestDto, response);
    }

    // 중복확인
    @PostMapping("/check")
    public ResponseEntity<SendMessageDto> emailCheck(@RequestBody LoginRequestDto loginRequestDto) {
        return userService.emailCheck(loginRequestDto);
    }
}