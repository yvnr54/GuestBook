/**
 * 
 */
package com.bt.guestbook.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class provides Security to the application.
 * it is accessing the datasource and connecting to it and performing the securtity operations.
 * 
 * @author Venkat
 *
 */
@Configuration
@EnableWebSecurity      
public class GuestBookSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    DataSource dataSource;

    /**
     * Securing the urls and allowing role-based access to these urls.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/*").hasRole("USER") 
        .and().formLogin().loginPage("/login")
		.and().logout().permitAll()
        .and().csrf().disable();
    }
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

   
    
    
}
