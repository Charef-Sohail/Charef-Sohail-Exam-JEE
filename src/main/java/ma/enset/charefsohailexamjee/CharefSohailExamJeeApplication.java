package ma.enset.charefsohailexamjee;

import ma.enset.charefsohailexamjee.entities.Client;
import ma.enset.charefsohailexamjee.entities.ContratAutomobile;
import ma.enset.charefsohailexamjee.entities.Paiement;
import ma.enset.charefsohailexamjee.enums.ContratStatut;
import ma.enset.charefsohailexamjee.enums.PaiementType;
import ma.enset.charefsohailexamjee.repositories.ClientRepository;
import ma.enset.charefsohailexamjee.repositories.ContratRepository;
import ma.enset.charefsohailexamjee.repositories.PaiementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CharefSohailExamJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharefSohailExamJeeApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepo, ContratRepository contratRepo, PaiementRepository paiementRepo) {
        return args -> {
            // 1. Créer un client
            Client c1 = clientRepo.save(new Client(null, "Sohail", "Charef@email.com", null));

            // 2. Créer un contrat auto pour ce client
            ContratAutomobile ca = new ContratAutomobile();
            ca.setClient(c1);
            ca.setStatut(ContratStatut.EN_COURS);
            ca.setMarque("Toyota");
            ca.setModele("Yaris");
            contratRepo.save(ca);

            // 3. Créer un paiement
            paiementRepo.save(new Paiement(null, new Date(), 500.0, PaiementType.MENSUALITE, ca)); // [cite: 21]

            System.out.println("client bien cree avec son contrat !");
        };
    }
}
