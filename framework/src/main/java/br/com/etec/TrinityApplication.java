package br.com.etec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.etec.integration.client")
public class TrinityApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrinityApplication.class, args);
    }
}