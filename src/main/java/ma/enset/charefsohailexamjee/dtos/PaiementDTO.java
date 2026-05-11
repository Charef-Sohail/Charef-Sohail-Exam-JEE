package ma.enset.charefsohailexamjee.dtos;

import lombok.Data;
import ma.enset.charefsohailexamjee.enums.PaiementType;

import java.util.Date;


@Data
public class PaiementDTO {
    private Long id;
    private Date date;
    private double montant;
    private PaiementType type;
    private Long contratId;
}