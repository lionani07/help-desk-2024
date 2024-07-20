package br.com.lionani07.helpdesk.config;

import br.com.lionani07.helpdesk.services.DbService;
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
