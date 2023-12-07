package com.example.luluapp.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests-> requests.anyRequest().authenticated());
        http.formLogin(form->form.loginPage("/login").permitAll());
        http.logout(out-> out.logoutSuccessUrl("/"));
        http.csrf(csrf-> csrf.disable());
            return http.build();
    }
}

