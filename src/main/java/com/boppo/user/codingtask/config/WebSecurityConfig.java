package com.boppo.user.codingtask.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String[] WHITE_LIST_URLS = {
            "/register",
            "/"
    };

    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(WHITE_LIST_URLS).permitAll()
                .requestMatchers("/login")
                .authenticated()
                .requestMatchers("/users/**")
                .authenticated()
                .and()
                .httpBasic();

        return httpSecurity.build();
    }

}
