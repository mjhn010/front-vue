package kr.co.pofo.pofoapiboot3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class PofoSecurityConfig {
//docs.spring.io/spring-security/reference/servlet/authorization/expression-based.html
//www.baeldung.com/spring-security-thymeleaf
   
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

   http.csrf().disable()
   .authorizeHttpRequests(authorize -> authorize
       .requestMatchers("/admin/**").hasRole("ADMIN")
       .requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
       .anyRequest().permitAll()
   )
   .formLogin()
       .loginPage("/user/login") //GET
       .loginProcessingUrl("/user/login") //post
       .defaultSuccessUrl("/index")
   .and()
           .logout()
           .logoutUrl("/user/logout")
           .logoutSuccessUrl("/");

       return http.build();
   }

   
   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();      
   }
}