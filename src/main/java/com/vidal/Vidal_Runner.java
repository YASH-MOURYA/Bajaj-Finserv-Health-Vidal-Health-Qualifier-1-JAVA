package com.vidal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Vidal_Runner implements CommandLineRunner {

    private final Api_Vidal_Health api;

    public Vidal_Runner(Api_Vidal_Health apiVidal) {
        this.api = apiVidal;
    }

    @Override
    public void run(String... args) {
        System.out.println("Vidal Health App IS  started");
        api.runTask();
    }
}