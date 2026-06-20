package project.ec2session.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.ec2session.domain.user.dto.TokenDto;
import project.ec2session.domain.user.dto.UserReq;
import project.ec2session.domain.user.service.AuthService;

import java.util.HashMap;
import java.util.Map;

@Tag(
        name = "Auth",
        description = "회원가입 및 로그인 API"
)
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(
            summary = "로그인",
            description = "아이디와 비밀번호를 이용하여 로그인하고 JWT 토큰을 발급받습니다."
    )
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(
            @RequestBody @Valid UserReq.SignInDto request
    ) {
        TokenDto response = authService.signIn(request);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "회원가입",
            description = "새로운 사용자를 등록합니다."
    )
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(
            @RequestBody @Valid UserReq.SignUpDto request
    ) {
        Long userId = authService.signUp(request);

        Map<String, Object> response = new HashMap<>();
        response.put("userId", userId);
        return ResponseEntity.ok(response);
    }
}