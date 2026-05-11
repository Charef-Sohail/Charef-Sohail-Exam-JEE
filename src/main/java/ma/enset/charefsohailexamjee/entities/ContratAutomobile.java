package ma.enset.charefsohailexamjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("AUTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratAutomobile extends ContratAssurance {
    private String immatriculation;
    private String marque;
    private String modele;
}