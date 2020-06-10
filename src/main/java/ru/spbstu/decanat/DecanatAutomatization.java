package ru.spbstu.decanat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.spbstu.decanat.entity.Subject;
import ru.spbstu.decanat.repository.SubjectRepository;


@SpringBootApplication
public class DecanatAutomatization {
    private static final Logger log = LoggerFactory.getLogger(DecanatAutomatization.class);

    public static void main(String[] args) {
        SpringApplication.run(DecanatAutomatization.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
/*    @Bean
    public CommandLineRunner test(SubjectRepository repository) {
        return args -> {
            repository.save(new Subject(2, "Math"));
            repository.save(new Subject(12, "OOP"));

            for (Subject sub : repository.findAll()) {
                log.info("THe subject is: " + sub.toString());
            }
        };
    }*/
}