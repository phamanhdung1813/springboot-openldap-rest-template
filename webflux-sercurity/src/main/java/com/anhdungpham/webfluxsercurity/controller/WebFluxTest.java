package com.anhdungpham.webfluxsercurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxTest {
    @GetMapping("/hello_admin")
    Mono<String> admin(){
        return Mono.just("ADMIN WEB FLUX DEMO");
    }

    @GetMapping("/hello_user")
    Mono<String> user(){
        return Mono.just("ANY USER WEB FLUX DEMO");
    }
}
