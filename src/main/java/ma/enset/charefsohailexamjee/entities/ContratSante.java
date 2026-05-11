package ma.enset.charefsohailexamjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.charefsohailexamjee.enums.NiveauCouverture;

@Entity
@DiscriminatorValue("SANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratSante extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;
    private int nbPersonnes;
}