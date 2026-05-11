package ma.enset.charefsohailexamjee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("client").password("{noop}1234").roles("CLIENT").build(),
                User.withUsername("employe").password("{noop}1234").roles("EMPLOYE").build(),
                User.withUsername("admin").password("{noop}1234").roles("ADMIN").build()
        );
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(authProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/login", "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**").permitAll());

       http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/api/clients/**").hasAnyRole("EMPLOYE", "ADMIN"));
        http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "/api/clients/**").hasRole("ADMIN"));

        http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/api/contrats/**").hasAnyRole("CLIENT", "EMPLOYE", "ADMIN"));

        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}