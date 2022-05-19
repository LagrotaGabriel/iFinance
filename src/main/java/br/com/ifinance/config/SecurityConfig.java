package br.com.ifinance.config;

import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.SSUserDetailsService;
import br.com.ifinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SSUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .antMatchers("/index").hasAnyRole("USER", "ADMIN")
                .antMatchers("/swagger-ui.html").hasAnyRole("ADMIN")
                .antMatchers("/api/**").hasAnyRole("ADMIN")
                .antMatchers("/signup").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("762")).roles("USER", "ADMIN");

        auth.userDetailsService(userDetailsServiceBean())
                .passwordEncoder(passwordEncoder());
    }


}
