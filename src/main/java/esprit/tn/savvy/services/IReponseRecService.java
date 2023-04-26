package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Reclamation;
import esprit.tn.savvy.entities.ReponseRec;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReponseRecService {
  /*  ResponseEntity<ReponseRec> createReponse(ReponseRec reponse, Integer idRec);

   */
  ReponseRec retrieveReponseRec(Integer idrep);
    List<ReponseRec> getAllReponseRecs();

    ResponseEntity<ReponseRec> addReponse(ReponseRec reponse, Integer idRec);
}

