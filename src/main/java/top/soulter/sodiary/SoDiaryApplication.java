package top.soulter.sodiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SoDiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoDiaryApplication.class, args);
    }

}
