package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Etat;
import esprit.tn.savvy.entities.Reclamation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import esprit.tn.savvy.repsitory.ReclamationRepository;


import java.util.*;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReclamationService implements IReclamationService {
    @Autowired
    ReclamationRepository reclamationRepository;

    /*@Override
    public Optional<Reclamation> findByidReclamation(Integer id) {
        return reclamationRepository.findByidReclamation(idReclamation);
    }

     */


    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        reclamation.setEtat(Etat.Non_Traite);
        return reclamationRepository.save(reclamation);
    }


    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        Reclamation existingReclamation = reclamationRepository.findById(reclamation.getIdReclamation()).get();
        existingReclamation.setSujet(reclamation.getSujet());
        existingReclamation.setEtat(reclamation.getEtat());
        existingReclamation.setContenu(reclamation.getContenu());
        existingReclamation.setDaterec(reclamation.getDaterec());
        return reclamationRepository.save(existingReclamation);
    }



    @Override
    public Reclamation retrieveReclamation(Integer idReclamation) {
        return reclamationRepository.findById(idReclamation).orElse(null);
    }


    @Override
    public List<Reclamation> getAllReclamations() {
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    @Override
    public void removeReclamation(Reclamation reclamation) {

    }

    @Override
    public Map<String, Long> getReclamationsCountByState() {
        List<Reclamation> reclamations = getAllReclamations();
        Map<String, Long> countByState = new HashMap<>();

        for (Reclamation r : reclamations) {
            String state = r.getEtat() == null ? "null" : r.getEtat().toString();
            countByState.put(state, countByState.getOrDefault(state, 0L) + 1L);
        }

        return countByState;
    }

   /* @Override
    public List<Reclamation> advancedSearch(String sujet, String etat, String contenu) {
        return null;
    }

    */




  /*  @Override

    public List<Reclamation> findReclamationBysujet(String sujet) {
        return rr.findReclamationBysujet(sujet);
    }

   */



   @Override
    public List<Reclamation> advancedSearch(String sujet, String etat, String contenu, Date daterec) {
        if (sujet == null && etat == null && contenu == null && daterec == null) {
            return getAllReclamations();
        } else if (sujet != null && etat == null && contenu == null && daterec == null) {
            return reclamationRepository.findReclamationBysujet(sujet);
        } else if (sujet == null && etat != null && contenu == null && daterec == null) {
            return reclamationRepository.findReclamationByetat(etat);
        } else if (sujet == null && etat == null && contenu != null && daterec == null) {
            return reclamationRepository.findReclamationBycontenu(contenu);
        } else if (sujet != null && etat != null && contenu == null && daterec == null) {
            return reclamationRepository.findReclamationBysujetAndEtat(sujet, etat);
        } else if (sujet != null && etat == null && contenu != null && daterec == null) {
            return reclamationRepository.findReclamationBysujetAndContenu(sujet, contenu);
        } else if (sujet == null && etat != null && contenu != null && daterec == null) {
            return reclamationRepository.findReclamationByetatAndContenu(etat, contenu);
        } else if (sujet == null && etat == null && contenu == null && daterec != null) {
            return reclamationRepository.findReclamationByDaterec(daterec);
        } else if (sujet != null && etat != null && contenu == null && daterec != null) {
            return reclamationRepository.findReclamationBysujetAndEtatAndDaterec(sujet, etat, daterec);
        } else if (sujet != null && etat == null && contenu != null && daterec != null) {
            return reclamationRepository.findReclamationBysujetAndContenuAndDaterec(sujet, contenu, daterec);
        } else if (sujet == null && etat != null && contenu != null && daterec != null) {
            return reclamationRepository.findReclamationByetatAndContenuAndDaterec(etat, contenu, daterec);
        } else {
            return reclamationRepository.findReclamationBysujetAndEtatAndContenuAndDaterec(sujet, etat, contenu, daterec);
        }
    }






}







