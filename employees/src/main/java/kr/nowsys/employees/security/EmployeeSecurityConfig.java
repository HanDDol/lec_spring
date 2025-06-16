package kr.nowsys.employees.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class EmployeeSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails admin = User.builder().username("admin").password("{noop}admin").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//        UserDetails user1 = User.builder().username("user1").password("{noop}same_thing").roles("EMPLOYEE", "MANAGER").build();
//        UserDetails user2 = User.builder().username("user2").password("{noop}same_thing").roles("EMPLOYEE").build();
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(
          configurer -> configurer
                  .requestMatchers(HttpMethod.GET, "/api/members").hasRole("EMPLOYEE")
                  .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("EMPLOYEE")
                  .requestMatchers(HttpMethod.PUT, "/api/members/**").hasRole("MANAGER")
                  .requestMatchers(HttpMethod.POST, "/api/members").hasRole("MANAGER")
                  .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasRole("ADMIN")
        );



        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf( csrf -> csrf.disable() );

        return httpSecurity.build();
    }
}
