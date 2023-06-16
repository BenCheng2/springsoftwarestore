package store.softstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Set the allowed origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Set the allowed HTTP methods
                .allowedHeaders("Content-Type", "Authorization") // Set the allowed headers
                .allowCredentials(true); // Allow the browser to send cookies and other credentials
    }
}
