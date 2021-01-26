package org.enset.contrat;

import org.enset.contrat.model.Contrat;
import org.enset.contrat.repository.ContratRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class ContratApplication {

    public static void main(String[] args) {
        org.enset.contrat.aspects.ApplicationContext.authenticateUser("root","123",new String[]{"ADMIN"});
        SpringApplication.run(ContratApplication.class, args);
    }

}
