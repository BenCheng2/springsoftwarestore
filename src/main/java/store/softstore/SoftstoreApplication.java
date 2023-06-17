package store.softstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import store.softstore.model.Role;
import store.softstore.repository.RoleRepository;

@SpringBootApplication
public class SoftstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(RoleRepository roleRepository) {
        return args -> {
            // Set up the role data
            roleRepository.save(new Role(1L, "ROLE_USER"));
            roleRepository.save(new Role(2L, "ROLE_COMPANY"));
            roleRepository.save(new Role(3L, "ROLE_ADMIN"));
        };
    }
}
