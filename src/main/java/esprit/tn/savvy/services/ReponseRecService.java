package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Reclamation;
import esprit.tn.savvy.entities.ReponseRec;
import esprit.tn.savvy.entities.Etat;
import esprit.tn.savvy.repsitory.ReclamationRepository;
import esprit.tn.savvy.repsitory.ReponseRecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReponseRecService implements IReponseRecService{
    @Autowired
    ReponseRecRepository reponseRecRepository;

    @Autowired
    ReclamationRepository reclamationRepository;
    @Autowired
    private EmailSenderService senderService;
    /*
    @Override
    public ResponseEntity<ReponseRec> createReponse(ReponseRec reponse, Integer idRec) {
        try {
            Optional<Reclamation> reclamationOpt = ReclamationRepository.findByidReclamation(idRec);
            if (!reclamationOpt.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Reclamation reclamation = reclamationOpt.get();
            if (reclamation.getEtat().toString().equals("Traite")) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            reponse.setReclamation(reclamation);

            reclamation.setEtat(Etat.Traite);
            ReclamationRepository.save(reclamation);
            ReponseRecRepository.save(reponse);

            return new ResponseEntity<>(reponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     */

    @Override
    public ReponseRec retrieveReponseRec(Integer idrep) {
        return reponseRecRepository.findById(idrep).orElse(null);
    }

    @Override
    public List<ReponseRec> getAllReponseRecs() {
        return (List<ReponseRec>) reponseRecRepository.findAll();

    }

    @Override
    public ResponseEntity<ReponseRec> addReponse(ReponseRec reponse, Integer idRec) {
        Reclamation reclamation = reclamationRepository.findById(idRec).orElse(null);
        System.out.println(reclamation);
        if (reclamation.getEtat().toString().equals("Traite")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //a
        reponse.setReclamation(reclamation);
        reclamation.setEtat(Etat.Traite);
        reclamationRepository.save(reclamation);
        reponseRecRepository.save(reponse);
        String email = "rania.elhor@esprit.tn";
        senderService.sendSimpleEmail(email,
                "Votre Reclamation est bien traite /n Merci de bien verifier la platform ",
                "Reclamation");
        return new ResponseEntity<>(reponse,HttpStatus.OK);
    }


}
