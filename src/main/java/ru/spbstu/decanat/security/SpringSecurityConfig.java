package ru.spbstu.decanat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ru.spbstu.decanat.security.jwt.JwtSecurityConfigurer;
import ru.spbstu.decanat.security.jwt.JwtTokenProvider;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
          .csrf().disable()
          .formLogin().disable()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and()
          .authorizeRequests()
          .antMatchers("/auth/signin").permitAll()
          .antMatchers(HttpMethod.GET, "/marks/all").permitAll()
          .antMatchers(HttpMethod.GET, "/person/all").permitAll()
          .antMatchers(HttpMethod.GET, "/subjects/all").permitAll()
          .antMatchers(HttpMethod.GET, "/groups/all").permitAll()
          .antMatchers(HttpMethod.GET, "/marks/{id}").hasRole("USER")
          .antMatchers(HttpMethod.GET, "/person/{id}").hasRole("USER")
          .antMatchers(HttpMethod.GET, "/subjects/{id}").hasRole("USER")
          .antMatchers(HttpMethod.GET, "/groups/{id}").hasRole("USER")
          .antMatchers(HttpMethod.GET, "/marks/{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.GET, "/people/{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.GET, "/subjects/{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.GET, "/groups/{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.POST, "/marks/add").hasRole("ADMIN")
          .antMatchers(HttpMethod.POST, "/person/add/").hasRole("ADMIN")
          .antMatchers(HttpMethod.POST, "/subjects/add").hasRole("ADMIN")
          .antMatchers(HttpMethod.POST, "/groups/add").hasRole("ADMIN")
          .antMatchers(HttpMethod.POST, "/marks/delete/{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.POST, "/person/delete/{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.POST, "/subject/delete/{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.POST, "/groups/delete/{id}").hasRole("ADMIN")
          .anyRequest().authenticated()
          .and()
          .apply(new JwtSecurityConfigurer(jwtTokenProvider));
    }
}