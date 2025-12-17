package com.triet.global_track_trace.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI globalTrackTraceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Global Track & Trace API")
                        .description("Enterprise Global Track & Trace Platform API")
                        .version("v1.0.0"));
    }
}
