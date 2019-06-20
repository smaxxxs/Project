package admission;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import admission.service.UserService;

@TestConfiguration
public class TestConfig {

    @Bean
    public UserService restTemplateBuilder() {

        return new UserService();
    }
}