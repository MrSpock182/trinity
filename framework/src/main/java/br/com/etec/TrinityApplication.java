package br.com.etec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class TrinityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrinityApplication.class, args);
    }

}
