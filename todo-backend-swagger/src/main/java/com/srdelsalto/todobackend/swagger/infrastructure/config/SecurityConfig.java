package com.srdelsalto.todobackend.swagger.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        String moduleName = "/todo/**";

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        moduleName,"/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**")
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS,
                        moduleName,"/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**")
                .permitAll()
                .antMatchers(HttpMethod.POST,
                        moduleName,"/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**")
                .permitAll()
                .antMatchers(HttpMethod.PUT,
                        moduleName,"/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**")
                .permitAll()
                .antMatchers(HttpMethod.DELETE,
                        moduleName,"/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**")
                .permitAll()
                .antMatchers("/v3/api-docs/**",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/swagger-ui/index.html",
                        "/swagger-ui/**",
                        "/webjars/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .headers().contentSecurityPolicy("script-src 'self'");

        return http.build();
    }
}
