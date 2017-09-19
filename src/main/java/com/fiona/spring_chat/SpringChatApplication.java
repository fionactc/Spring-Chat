package com.fiona.spring_chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SpringChatApplication extends WebSecurityConfigurerAdapter {
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
					.antMatcher("/**")
					.authorizeRequests()
						.antMatchers("/")
						.permitAll()
					.and().logout().permitAll()
					.logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
						httpServletResponse.setStatus(HttpServletResponse.SC_OK);
					})
					.and().csrf().disable();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringChatApplication.class, args);
	}
}
