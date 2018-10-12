package pl.maniaq.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web)throws Exception{
       // web.ignoring().antMatchers("/resources/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        /*http.authorizeRequests().antMatchers("/books/add/**").permitAll() // what alllow
                .antMatchers("/books/list/**").hasAnyRole("ADMIN") // what block
                .anyRequest().authenticated().and().formLogin()
                .permitAll().and().logout().permitAll();

        http.csrf().disable();*/


    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManager) throws Exception{
        /*authenticationManager.inMemoryAuthentication().withUser("admin").password("{admin}admin").authorities("ROLE_ADMIN");
*/

    }




}
