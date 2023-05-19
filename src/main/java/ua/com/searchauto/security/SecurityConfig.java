package ua.com.searchauto.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ua.com.searchauto.security.filters.JWTFilter;


@AllArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private JWTFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST,"/clients/save","/clients/login").permitAll()
                .requestMatchers("**/clients/**").permitAll()
                .requestMatchers(HttpMethod.POST,"autos/users/**").hasAnyAuthority("USER","SELLER","ADMIN")
                .requestMatchers(HttpMethod.PATCH,"autos/users/**").hasAnyAuthority("USER","SELLER","ADMIN")
                .requestMatchers(HttpMethod.DELETE,"autos/users/**").hasAnyAuthority("USER","SELLER","MANAGER","ADMIN")
                .requestMatchers("/autos/users/**").hasAnyAuthority("USER","MANAGER","SELLER","ADMIN")
                .requestMatchers("/autos/mechanics/**").hasAnyAuthority("ADMIN","MECHANIC")
                .requestMatchers("/managers/**").hasAnyAuthority("USER","MANAGER","ADMIN")
                .requestMatchers("/admins/**").hasAnyAuthority("ADMIN")

                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


//    @Bean
//    public UserDetailsService users(){
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        UserDetails admin = userBuilder.username("admin")
//                .password("asdqwe")
//                .roles("ADMIN")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(admin);
//    }


}
