//package com.cts.config;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import com.cts.service.MongoUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final MongoUserDetailsService userDetailsService;
//
//    public SecurityConfig(MongoUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http
//            .csrf(csrf -> csrf.disable())
//            .cors(Customizer.withDefaults())
//
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers(
//                    new AntPathRequestMatcher("/auth/**")
//                ).permitAll()
//
//                .requestMatchers(
//                    new AntPathRequestMatcher("/api/employees/**", "GET")
//                ).hasAnyRole("USER", "ADMIN")
//
//                .requestMatchers(
//                    new AntPathRequestMatcher("/api/employees/**", "POST"),
//                    new AntPathRequestMatcher("/api/employees/**", "PUT"),
//                    new AntPathRequestMatcher("/api/employees/**", "DELETE")
//                ).hasRole("ADMIN")
//
//                .anyRequest().authenticated()
//            )
//
//            .formLogin(form -> form
//                .loginProcessingUrl("/auth/login")
//                .successHandler((req, res, auth) ->
//                    res.setStatus(HttpServletResponse.SC_OK)
//                )
//                .failureHandler((req, res, ex) ->
//                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials")
//                )
//            )
//
//            .logout(logout -> logout
//                .logoutUrl("/auth/logout")
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutSuccessHandler((req, res, auth) ->
//                    res.setStatus(HttpServletResponse.SC_OK)
//                )
//            )
//
//            .userDetailsService(userDetailsService);
//
//        return http.build();
//    }
//    
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.setAllowCredentials(true); // REQUIRED for cookies
//        config.addAllowedOrigin("http://localhost:4200"); // Angular
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//
//        UrlBasedCorsConfigurationSource source =
//                new UrlBasedCorsConfigurationSource();
//
//        source.registerCorsConfiguration("/**", config);
//
//        return source;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
