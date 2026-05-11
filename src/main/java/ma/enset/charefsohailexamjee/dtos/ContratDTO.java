package ma.enset.charefsohailexamjee.dtos;


import lombok.Data;
import ma.enset.charefsohailexamjee.enums.ContratStatut;

import java.util.Date;

@Data
public class ContratDTO {
    private Long id;
    private Date dateSouscription;
    private ContratStatut statut;
    private double montantCotisation;
    private String typeContrat;
}