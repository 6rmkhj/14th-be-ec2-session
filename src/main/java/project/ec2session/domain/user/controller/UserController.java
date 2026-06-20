package project.ec2session.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import project.ec2session.common.auth.CustomUserDetails;
import project.ec2session.domain.user.dto.UserReq;
import project.ec2session.domain.user.service.UserService;

@Tag(
        name = "User",
        description = "회원 API"
)
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "내 정보 조회",
            description = "현재 로그인한 사용자의 정보를 조회합니다."
    )
    @GetMapping("/me")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(userService.readById(userDetails.getUserId()));
    }

    @Operation(
            summary = "전체 회원 조회",
            description = "등록된 모든 회원 정보를 조회합니다."
    )
    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(userService.readAll());
    }

    @Operation(
            summary = "회원 정보 수정",
            description = "현재 로그인한 사용자의 닉네임을 수정합니다."
    )
    @PutMapping
    public ResponseEntity<?> updateUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails,
                                            @RequestBody @Valid UserReq.UpdateInfo request) {
        userService.update(userDetails.getUserId(), request);
        return ResponseEntity.ok("요청 성공");
    }
    @Operation(
            summary = "회원 탈퇴",
            description = "현재 로그인한 사용자를 삭제합니다."
    )
    @DeleteMapping
    public ResponseEntity<?> deleteUser(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        userService.delete(userDetails.getUserId());

        return ResponseEntity.ok("회원 탈퇴 완료");
    }
}
