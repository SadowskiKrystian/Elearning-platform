package com.example.elearningplatform.security;

import com.example.elearningplatform.auth.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class LoginSecurity {
    @Autowired
    private DataSource dataSource;
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, password, 'true' as enabled from user where email = ?;")
                .authoritiesByUsernameQuery("select email, role from user where email = ?;");
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests((aut) -> aut

//                        .requestMatchers("/index", "/login", "/news", "/registration", "/quest/add-new-login").permitAll()
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .requestMatchers("/admin/**").hasAuthority(UserRole.ADMIN.getCodeWithRole())
                        .anyRequest().permitAll()
                )
                .formLogin(
                        form -> form
                        .loginPage("/login")
                                .defaultSuccessUrl("/logging")
                                .usernameParameter("email")
                                .passwordParameter("password")
                                .permitAll()
                );

        return httpSecurity.build();
    }


}
