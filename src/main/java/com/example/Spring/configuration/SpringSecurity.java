package com.example.Spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable).
                authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(HttpMethod.GET, "/metal/spot-prices", "metal/spot-price", "/metal/paginated-spot-prices").permitAll()
                                .requestMatchers(HttpMethod.POST, "/user/add").permitAll()
                                .requestMatchers(HttpMethod.GET, "/user/admin").hasAuthority("ADMIN")
                                .requestMatchers("/user/**", "/transaction/**", "/metal/**").authenticated()
                                .requestMatchers("/**").anonymous()

                )
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        String getUser = "Select email as username, password, 'true' as enabled FROM User WHERE email = ?";
        String getAuth = "Select email as username, role as authority FROM User WHERE email = ?";
        userDetailsManager.setUsersByUsernameQuery(getUser);
        userDetailsManager.setAuthoritiesByUsernameQuery(getAuth);

        return userDetailsManager;
    }
}


