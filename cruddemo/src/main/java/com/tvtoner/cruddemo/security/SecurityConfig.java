package com.tvtoner.cruddemo.security;

import com.tvtoner.cruddemo.entity.Employee;
import com.tvtoner.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig {

    private final EmployeeService employeeService;

    @Autowired
    public SecurityConfig(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        List<Employee> employees = employeeService.findAll();
        List<UserDetails> userDetailsList = new ArrayList<>();

        for (Employee employee : employees) {
            UserDetails userDetails = createUserDetails(employee);
            userDetailsList.add(userDetails);
        }

        return new InMemoryUserDetailsManager(userDetailsList);
    }

    private UserDetails createUserDetails(Employee employee) {
        String password = "{noop}";
        switch (employee.getiD()) {
            case 1:
                password += "test123";
                return User.withUsername(employee.getFirstName())
                        .password(password)
                        .roles("EMPLOYEE", "MANAGER", "ADMIN")
                        .build();
            case 2:
                password += "hello123";
                return User.withUsername(employee.getFirstName())
                        .password(password)
                        .roles("EMPLOYEE", "MANAGER")
                        .build();
            default:
                password += "fun123";
                return User.withUsername(employee.getFirstName())
                        .password(password)
                        .roles("EMPLOYEE")
                        .build();
        }
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        // Employee REST Controller
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                        // EmployeeSkills REST Controller
                        .requestMatchers(HttpMethod.GET, "/api/employees/{employeeId}/skills").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees/{employeeId}/skills/{skillId}").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/{employeeId}/skills/{skillId}").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/{employeeId}/skills/{skillId}").hasRole("ADMIN")
                        // Payroll REST Controller
                        .requestMatchers(HttpMethod.GET, "/api/payrolls").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/payrolls/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/payrolls").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/payrolls").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/payrolls/**").hasRole("ADMIN")
                        // Skill REST Controller
                        .requestMatchers(HttpMethod.GET, "/api/skills").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/skills/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/skills").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/skills").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/skills/**").hasRole("ADMIN")
                        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}