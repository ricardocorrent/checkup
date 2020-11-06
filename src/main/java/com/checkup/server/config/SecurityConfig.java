package com.checkup.server.config;

import com.checkup.server.security.jwt.JwtConfigurer;
import com.checkup.server.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Inject
    private JwtTokenProvider tokenProvider;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //authorization configuration
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signin").permitAll()
                .antMatchers("/api-docs/**").permitAll()
                .antMatchers("/swagger-ui.html**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/users").denyAll()
                .and()
                .cors(Customizer.withDefaults())
                .apply(new JwtConfigurer(tokenProvider));
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }
}
