package vn.iostar.SpringSer.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vn.iostar.SpringSer.Repository.UserInfoRepository;
import vn.iostar.SpringSer.services.UserInfoService;

@Configuration
public class SecurityConfig {

    private final UserInfoRepository repository;

    public SecurityConfig(UserInfoRepository repository) {
        this.repository = repository;
    }

    // Authentication
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoService(repository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    // SecurityFilterChain for Spring Security 6.1+
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/new").permitAll() // Public access
                        .requestMatchers("/").permitAll()          // Public access
                        .requestMatchers(new AntPathRequestMatcher("/customer/**")).authenticated() // Authentication required
                )
                .formLogin(form -> form.defaultSuccessUrl("/", true)) // Enable form login
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/")) // Handle logout
                .build();
    }
    
}
