package ma.enset.charefsohailexamjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.charefsohailexamjee.enums.LogementType;

@Entity
@DiscriminatorValue("HABITATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratHabitation extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private LogementType typeLogement;
    private String adresse;
    private double superficie;
}