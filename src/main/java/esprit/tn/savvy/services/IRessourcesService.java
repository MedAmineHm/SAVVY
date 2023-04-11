package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Ressources;

import java.util.List;

public interface IRessourcesService {
    List<Ressources> getAllRessources();
    Ressources getRessourcesById(Integer idRess);
    Ressources createRessources(Ressources ressources);
    Ressources updateRessources(Integer idRess, Ressources ressources);
    void deleteRessources(Integer idRess);
}



