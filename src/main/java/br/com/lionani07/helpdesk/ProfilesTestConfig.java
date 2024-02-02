package br.com.lionani07.helpdesk;

import br.com.lionani07.helpdesk.services.DbService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ProfilesTestConfig {

    @Autowired
    private DbService dbService;

    @Bean
    public String initDB() {
        this.dbService.initDB();
        return "Db iniciado";
    }
}
