package securiry;

@Configuration

public class WebSecurityConfig {
	
	@Bean
	public JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}
	
	@Bean
	
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/auth/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
	http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	
	return http.build();
	
	}
	
	@Bean
	 public AuthenticationManager authenticationManager (AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

}
