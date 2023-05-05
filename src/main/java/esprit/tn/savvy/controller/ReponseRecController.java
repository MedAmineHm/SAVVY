package esprit.tn.savvy.controller;

import esprit.tn.savvy.entities.Reclamation;
import esprit.tn.savvy.entities.ReponseRec;
import esprit.tn.savvy.services.IReponseRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReponseRecController {
    @Autowired
    IReponseRecService iReponse;
   /* @PostMapping("/add/{id}")
    public ResponseEntity<ReponseRec> createReponse (@RequestBody ReponseRec reponse, @PathVariable Integer idRec) {
        return iReponse.createReponse(reponse,idRec);
    }

    */
    @PostMapping("/add/{idRec}")
    public ResponseEntity<ReponseRec> addReponse(@RequestBody ReponseRec reponse,@PathVariable Integer idRec) {
        return iReponse.addReponse(reponse,idRec);
    }

    @GetMapping("/get/{idrep}")
    public ReponseRec retrieveReponseRec(@PathVariable Integer idrep) {
        return iReponse.retrieveReponseRec(idrep);
    }

    @GetMapping("/affrep")
    public List<ReponseRec> getAllReponseRecs() {
        return iReponse.getAllReponseRecs();
    }

}
