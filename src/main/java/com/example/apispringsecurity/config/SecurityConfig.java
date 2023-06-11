package com.example.apispringsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity

public class SecurityConfig {



    private final PasswordEncoder pwdEncoder;

    public SecurityConfig(PasswordEncoder pwdEncoder) {
        this.pwdEncoder = pwdEncoder;
    }

    @Bean
    public InMemoryUserDetailsManager manager(){
        return new InMemoryUserDetailsManager(
          User
                  .withUsername("walid")
                  .password(pwdEncoder.encode("1234"))
                  .roles("USER","ADMIN")
                  .build()
        );
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.httpBasic(Customizer.withDefaults());
        http.formLogin();
        http.authorizeHttpRequests((auth)->auth
                .requestMatchers("api/v1/NoSecurity")
                .permitAll()
                .anyRequest()
                .authenticated()
        );
        return http.build();
    }




}

