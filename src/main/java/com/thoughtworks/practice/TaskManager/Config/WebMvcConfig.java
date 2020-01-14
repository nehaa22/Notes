//package com.thoughtworks.practice.TaskManager.Config;
//
//import com.thoughtworks.practice.TaskManager.User.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebMvcConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userService).passwordEncoder(User.PASSWORD_ENCODER);
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST,"/").permitAll()
//                .antMatchers(HttpMethod.POST,"/register").permitAll()
//                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .csrf().disable();
//
//    }
//}
