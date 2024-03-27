package com.example.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MnoFluxTest {
    @Test
    public void TestMono(){
        Mono<?> monoString = Mono.just("MonoSample")
                .then(Mono.error(new RuntimeException("exception occurred")))
                .log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }

    @Test
    public void TestFlux(){
        Flux<String> fluxString=Flux.just("spring","Springboot","hibernate")
                .concatWithValues("aws")
                .concatWith(Flux.error(new RuntimeException("exception occurred in flux")))
                .concatWithValues("cloud")
                .log();
        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
}
