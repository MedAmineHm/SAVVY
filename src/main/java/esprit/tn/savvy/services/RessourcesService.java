package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Ressources;
import esprit.tn.savvy.entities.User;
import esprit.tn.savvy.repositories.RessourcesRepository;
import esprit.tn.savvy.repositories.UserRepository;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class RessourcesService implements IRessourcesService  {

    @Autowired
    private RessourcesRepository ressourcesRepository;

    public List<Ressources> getAllRessources() {
        return ressourcesRepository.findAll();
    }

    public Ressources getRessourcesById(Integer idRess) {
        return ressourcesRepository.findById(idRess).orElseThrow(() -> new RuntimeException("Ressources not found with id: " + idRess));

    }

    public Ressources createRessources(Ressources ressources) {
        return ressourcesRepository.save(ressources);
    }

    public Ressources updateRessources(Integer idRess, Ressources ressources) {
        Ressources existingRessources = getRessourcesById(idRess);
        existingRessources.setCategory(ressources.getCategory());
        existingRessources.setQuantityRess(ressources.getQuantityRess());
        existingRessources.setImg(ressources.getImg());
        return ressourcesRepository.save(existingRessources);
    }

    public void deleteRessources(Integer idRess) {
        getRessourcesById(idRess); // to check if resource exists
        ressourcesRepository.deleteById(idRess);
    }

    @Autowired
    private UserRepository userRepository;

    public Ressources assignUserToRessources(Integer userId, Integer ressourcesId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user idUser"));
        Ressources ressources = ressourcesRepository.findById(ressourcesId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ressources idRess"));
        ressources.setUser(user);
        return ressourcesRepository.save(ressources);
    }
    public List<Ressources> findRessourcesByCategory(Category category) {
        return ressourcesRepository.findByCategory(category);
    }



}


