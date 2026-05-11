package ma.enset.charefsohailexamjee.services;

import lombok.AllArgsConstructor;
import ma.enset.charefsohailexamjee.dtos.ClientDTO;
import ma.enset.charefsohailexamjee.dtos.ContratDTO;
import ma.enset.charefsohailexamjee.entities.Client;
import ma.enset.charefsohailexamjee.entities.ContratAssurance;
import ma.enset.charefsohailexamjee.mappers.AssuranceMapper;
import ma.enset.charefsohailexamjee.repositories.ClientRepository;
import ma.enset.charefsohailexamjee.repositories.ContratRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AssuranceServiceImpl implements AssuranceService {

    private ClientRepository clientRepository;
    private ContratRepository contratRepository;
    private AssuranceMapper mapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return mapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> mapper.fromClient(client))
                .collect(Collectors.toList());
    }

    @Override
    public ContratDTO getContratById(Long id) {
        ContratAssurance contrat = contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable"));
        return mapper.fromContrat(contrat);
    }
}
