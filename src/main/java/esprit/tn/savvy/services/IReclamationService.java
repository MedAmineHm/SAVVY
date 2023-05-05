package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Reclamation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import java.util.Map;
import java.util.Optional;


public interface IReclamationService {
  //  Optional<Reclamation> findByidReclamation(Integer id);
    Reclamation addReclamation(Reclamation reclamation);
    Reclamation updateReclamation(Reclamation reclamation);
    Reclamation retrieveReclamation(Integer idReclamation);
    List<Reclamation> getAllReclamations();
    ResponseEntity <HttpStatus> removeReclamation(Integer id);


Map<String, Long> getReclamationsCountByState();





    List<Reclamation> advancedSearch(String sujet, String etat, String contenu, LocalDateTime daterec);


}
