package kr.ch09.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {
	@Autowired
	private SecurityUserService service;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		// 사이트 위변조 방지 설정
		.csrf(CsrfConfigurer::disable)
		// 인가 설정
		.authorizeHttpRequests((authorizeRequests) ->
        		authorizeRequests
        			.requestMatchers("/").permitAll()
        			.requestMatchers("/admin/**").hasRole("ADMIN")
        			.requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
        			.requestMatchers("/user/**").permitAll()
		)
		// 로그인 설정
		.formLogin((formLogin) ->
			formLogin
			.loginPage("/user/login")
			.defaultSuccessUrl("/user/success")
			.failureUrl("/user/login?success=100")
			.usernameParameter("uid")
			.passwordParameter("pass")
		)
		// 로그아웃 설정
		.logout((logout) ->
			logout
			.invalidateHttpSession(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
			.logoutSuccessUrl("/user/login?success=200")
		)
		// 사용자 인증처리 컴포넌트 등록
		.userDetailsService(service);
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}