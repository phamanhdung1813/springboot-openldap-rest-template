package com.anhdungpham.webfluxsercurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebFluxSecurity
public class WebfluxSercurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxSercurityApplication.class, args);
	}

	@Bean
	public MapReactiveUserDetailsService mapReactiveUserDetailsService() {
		List<UserDetails> userDetails = new ArrayList<>();
		userDetails.add(User.withDefaultPasswordEncoder()
				.username("webflux_anh").password("12345").roles("USER","ADMIN").build());

		userDetails.add(User.withDefaultPasswordEncoder()
				.username("webflux_pham").password("12345").roles("USER").build());
		return new MapReactiveUserDetailsService(userDetails);
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange().pathMatchers("/hello_admin").permitAll()
				.anyExchange().hasRole("ADMIN")
				.and().httpBasic();
		return http.build();
	}

}
