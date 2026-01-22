
package com.cts.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.cts.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // ✅ FRONTEND (NO LOGIN)
                .requestMatchers(
                    new AntPathRequestMatcher("/"),
                    new AntPathRequestMatcher("/index.jsp"),
                    new AntPathRequestMatcher("/resources/**"),
                    new AntPathRequestMatcher("/app/**"),
                    new AntPathRequestMatcher("/**/*.js"),
                    new AntPathRequestMatcher("/**/*.html"),
                    new AntPathRequestMatcher("/**/*.css")
                ).permitAll()

                //  LOGIN
                .requestMatchers(
                    new AntPathRequestMatcher("/auth/**")
                ).permitAll()
                
                //admin role
                .requestMatchers(
                        new AntPathRequestMatcher("/api/admin/**")
                    ).hasRole("ADMIN")

                    //  USER + ADMIN APIs
                    .requestMatchers(
                        new AntPathRequestMatcher("/api/user/**")
                    ).hasAnyRole("USER", "ADMIN")

                //  BACKEND API
                .requestMatchers(
                    new AntPathRequestMatcher("/api/**")
                ).authenticated()

                .anyRequest().denyAll()
            )

            //  SESSION LOGIN
            .formLogin(form -> form
                .loginProcessingUrl("/auth/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler((req, res, auth) -> res.setStatus(200))
                .failureHandler((req, res, ex) -> res.sendError(401))
            )

            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
