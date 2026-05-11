package ma.enset.charefsohailexamjee.web;


import lombok.AllArgsConstructor;
import ma.enset.charefsohailexamjee.dtos.ClientDTO;
import ma.enset.charefsohailexamjee.dtos.ContratDTO;
import ma.enset.charefsohailexamjee.services.AssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@AllArgsConstructor
public class AssuranceRestController {

    private AssuranceService assuranceService;

    // Récupérer la liste des clients
    @GetMapping("/clients")
    public List<ClientDTO> getClients() {
        return assuranceService.getAllClients();
    }

    // Ajouter un nouveau client
    @PostMapping("/clients")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return assuranceService.saveClient(clientDTO);
    }

    // Consulter un contrat spécifique
    @GetMapping("/contrats/{id}")
    public ContratDTO getContrat(@PathVariable Long id) {
        return assuranceService.getContratById(id);
    }
}