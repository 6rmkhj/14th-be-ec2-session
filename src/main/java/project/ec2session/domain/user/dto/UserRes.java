package project.ec2session.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import project.ec2session.domain.user.entity.User;

@Schema(description = "회원 정보 응답")
public record UserRes(
        @Schema(description = "회원 ID", example = "1")
        Long userId,
        @Schema(description = "아이디", example = "likelion")
        String username,
        @Schema(description = "닉네임", example = "아기사자")
        String nickname
) {
    public static UserRes from(User user) {
        return new UserRes(user.getId(), user.getUsername(), user.getNickname());
    }
}
