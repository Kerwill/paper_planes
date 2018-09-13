package fr.sopra.config;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/api/**").authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.anyRequest().hasAnyRole("ADMIN", "TECH")
				.and().httpBasic()
				.and().csrf().disable();
		}
	}

	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/assets/**").permitAll()
				.antMatchers("/**").hasAnyRole("ADMIN", "TECH")
				.and()
				.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/perform_login")
					.defaultSuccessUrl("/home", true)
					.failureUrl("/ma_page_de_login?error=true")
					.permitAll()
				.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/ma_page_de_deconnexion")
					.permitAll();
		}
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}