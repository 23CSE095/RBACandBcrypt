package com.example.internship.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class springConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf((csrf) -> csrf.disable())
                //.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .authorizeHttpRequests(auth ->{
//                    auth.requestMatchers(HttpMethod.POST,"/employee").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.PUT,"/employee").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.DELETE,"/employee").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN","USER");
                    auth.anyRequest().authenticated();
                })

                .httpBasic(Customizer.withDefaults());
                //.httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    //InMemoryUserDetailsManager userDetails() {
    UserDetailsService userDetailsService(){
        UserDetails admin = User.builder()
                .username("rbac")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

                UserDetails detail = User.builder()
                .username("moni")
                .password(passwordEncoder().encode("moni"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,detail);

    }
}
