package project.ec2session.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "14th BE EC2 Session API",
                description = "사용자 인증 및 회원 관리 API 문서",
                version = "1.0.0")
)
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi OpenApi() {
        String[] paths = {"/**"};

        return GroupedOpenApi.builder()
                .group("사용자 인증 및 회원 관리 API 문서")
                .pathsToMatch(paths)
                .build();
    }
}
