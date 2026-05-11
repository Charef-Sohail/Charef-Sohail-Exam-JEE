package ma.enset.charefsohailexamjee.services;

import ma.enset.charefsohailexamjee.dtos.ClientDTO;
import ma.enset.charefsohailexamjee.dtos.ContratDTO;

import java.util.List;

public interface AssuranceService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> getAllClients();
    ContratDTO getContratById(Long id);
}