package ru.otus.library2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.otus.library2.service.UserDetailsService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/authors", "/genres").access("hasRole('USER')")
        .antMatchers("/**").access("permitAll")

        .and()
        .formLogin()
        .loginPage("/login")

        .and()
        .logout()
        .logoutSuccessUrl("/")


        .and()
        .csrf()
        .ignoringAntMatchers("/h2-console/**")


        .and()
        .headers()
        .frameOptions()
        .sameOrigin()
    ;
  }
  @Bean
  public PasswordEncoder passwordEncoder () {
    return new BCryptPasswordEncoder();
  }


}