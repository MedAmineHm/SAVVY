package esprit.tn.savvy.services;

import com.google.gson.JsonObject;
import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.Ressources;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IRessourcesService {
    List<Ressources> getAllRessources();
    Ressources getRessourcesById(Integer idRess);
    Ressources createRessources(Ressources ressources);
    Ressources updateRessources(Integer idRess, Ressources ressources);
    void deleteRessources(Integer idRess);
    Ressources assignUserToRessources(Integer idUser, Integer ressourcesIdidRess);


    List<Ressources> findRessourcesByCategory(Category category);


    void saveRessources(Ressources ressources);

    void addImageToRessources(Integer idRess, MultipartFile file) throws IOException;


    List<Ressources> searchRessourcesByKeyword(String keyword);
    Page<Ressources> getAllRessourcesPaginated(int page, int size);

    List<Ressources> getFilteredRessources(Category category, Delivery delivery);

    List<Ressources> getRessourcesByUserId(Integer idUser);

    Map<Category, Long> getResourcesAvailableByCategory();
    Double getAverageResourcesPerUser();

    Category getMostFrequentCategory();

    void notifyWhenResourceCountReached(int count);
}



