package com.tutorialseu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable() )
                .authorizeHttpRequests(
                (requests)
                        -> requests
                        .requestMatchers("/public").permitAll()
                        // this allows all users to access public endpoint without any authentication
                        .requestMatchers("/admin/*").hasRole("ADMIN")
                            // only admin can access those pages
                        .requestMatchers("users/*").hasRole("USER")
                        // only user can access users
                        .anyRequest().authenticated()
                // till here  the code is saying that all request need authentication
        ).formLogin(withDefaults()) //  enable default login or the default login page
         .httpBasic(withDefaults()) // we want to enable basic authentication
         .logout(logout ->
                 logout.logoutUrl("/logout")
                         .invalidateHttpSession(true)
                         .deleteCookies("JSESSIONID")
                         .logoutSuccessHandler(
                                 (request, response, authentication) ->
                                 {response.setStatus(200);
                                  response.getWriter()
                                          .write("Logout Successful");}
                         )
         );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsManager () {
        UserDetails user1 = User.withUsername("Carlos").
                password(passwordEncoder().encode("Carlos123") // BCrypt-hashed password
                )
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("Admin").
                password(passwordEncoder().encode("admin")) // BCrypt-hashed password
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}
