package com.sec.aip.sharedpool.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .authorizeExchange {
                it.pathMatchers("/swagger-ui.html", "/v3/api-docs/**", "/webjars/**").permitAll()
                it.pathMatchers("/api/**").authenticated()
                it.anyExchange().permitAll()
            }
            .httpBasic { }
            .formLogin { it.disable() }
            .csrf { it.disable() }
            .build()
    }
}
