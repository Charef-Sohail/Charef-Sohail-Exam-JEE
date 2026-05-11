package ma.enset.charefsohailexamjee.mappers;

import ma.enset.charefsohailexamjee.dtos.ClientDTO;
import ma.enset.charefsohailexamjee.dtos.ContratDTO;
import ma.enset.charefsohailexamjee.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AssuranceMapper {

    public ClientDTO fromClient(Client client) {
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }

    public Client fromClientDTO(ClientDTO dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }

    public ContratDTO fromContrat(ContratAssurance contrat) {
        ContratDTO dto = new ContratDTO();
        BeanUtils.copyProperties(contrat, dto);
        if(contrat instanceof ContratAutomobile) {
            dto.setTypeContrat("Automobile");
        } else if(contrat instanceof ContratHabitation) {
            dto.setTypeContrat("Habitation");
        } else if(contrat instanceof ContratSante) {
            dto.setTypeContrat("Santé");
        }
        return dto;
    }
}