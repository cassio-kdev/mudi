package br.com.kdev.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/api/**")
			.permitAll()
			.antMatchers("/home/**")
			.permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.formLogin(form -> form
		            .loginPage("/login")
		            .permitAll().defaultSuccessUrl("/usuario/pedido",true)
		        )
			.logout(logout -> {
				logout.logoutUrl("/logout")
				.logoutSuccessUrl("/home");
				});
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		/*
		 * UserDetails user = User.builder() .username("maria")
		 * .password(encoder.encode("12345")) .roles("ADM") .build();
		 */
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);
		// .withUser(user);
	}

	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("joao") .password("joao")
	 * .roles("ADM") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */

}
