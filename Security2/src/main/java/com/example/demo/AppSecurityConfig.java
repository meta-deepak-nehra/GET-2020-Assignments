package com.example.demo;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.crypto.password.NoOpPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;

	@EnableWebSecurity
	public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private UserDetailsService userDetailsService;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			System.out.println("grvvv------ "+userDetailsService);
			auth.userDetailsService(userDetailsService);
			System.out.println("grvvv------ "+userDetailsService);
		}
		
		@Bean
		public PasswordEncoder getPasswordEncoder() {
			return NoOpPasswordEncoder.getInstance();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/**")
				.hasAnyAuthority("USER", "ADMIN")
				.and()
				.formLogin().defaultSuccessUrl("/loginuser", true);
		}
		
		
	}