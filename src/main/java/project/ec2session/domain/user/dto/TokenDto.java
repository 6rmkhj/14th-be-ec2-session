package project.ec2session.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "JWT 토큰 응답")
public record TokenDto(
        @Schema(
                description = "액세스 토큰"
        )
        String accessToken
) {
    public static TokenDto of(String accessToken) {
        return new TokenDto(accessToken);
    }
}
