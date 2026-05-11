package ma.enset.charefsohailexamjee.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.charefsohailexamjee.enums.ContratStatut;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CONTRAT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ContratAssurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateSouscription;
    @Enumerated(EnumType.STRING)
    private ContratStatut statut;
    private Date dateValidation;
    private double montantCotisation;
    private int duree;
    private double tauxCouverture;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "contrat")
    private List<Paiement> paiements;
}