package esprit.tn.savvy.repsitory;

import esprit.tn.savvy.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {


    List<Reclamation> findReclamationBysujet(String sujet);
    List<Reclamation> findReclamationByetat(String etat);
    List<Reclamation> findReclamationBycontenu(String contenu);
    List<Reclamation> findReclamationBysujetAndEtat(String sujet, String etat);
    List<Reclamation> findReclamationBysujetAndContenu(String sujet, String contenu);
    List<Reclamation> findReclamationByetatAndContenu(String etat, String contenu);


    List<Reclamation> findReclamationByDaterec(Date daterec);

    List<Reclamation> findReclamationBysujetAndEtatAndDaterec(String sujet, String etat, Date daterec);
    List<Reclamation> findReclamationBysujetAndContenuAndDaterec(String sujet, String contenu, Date daterec);
    List<Reclamation> findReclamationByetatAndContenuAndDaterec(String etat, String contenu, Date daterec);
    List<Reclamation> findReclamationBysujetAndEtatAndContenuAndDaterec(String sujet, String etat, String contenu, Date daterec);



    Optional<Reclamation> findByidReclamation(Integer idReclamation);



}
