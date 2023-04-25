package esprit.tn.savvy.services;

import com.google.gson.JsonObject;
import esprit.tn.savvy.controller.ResourceNotFoundException;
import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.Ressources;
import esprit.tn.savvy.entities.User;
import esprit.tn.savvy.repositories.RessourcesRepository;
import esprit.tn.savvy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class RessourcesService implements IRessourcesService  {

    @Autowired
    private RessourcesRepository ressourcesRepository;

    public List<Ressources> getAllRessources() {
        return ressourcesRepository.findAll();
    }

    public Ressources getRessourcesById(Integer idRess) {
        return ressourcesRepository.findById(idRess).orElseThrow(() -> new ResourceNotFoundException("Ressources not found with id: " + idRess));

    }

    public Ressources createRessources(Ressources ressources) {
        return ressourcesRepository.save(ressources);
    }

    public Ressources updateRessources(Integer idRess, Ressources ressources) {
        Ressources existingRessources = getRessourcesById(idRess);
        existingRessources.setIdRess(ressources.getIdRess());
        existingRessources.setNameRess(ressources.getNameRess());
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

    @Override
    public List<Ressources> findRessourcesByCategory(Category category) {
        return ressourcesRepository.findByCategory(category);
    }

    @Override
    public void saveRessources(Ressources ressources) {
        ressourcesRepository.save(ressources);
    }

    @Override
    public void addImageToRessources(Integer idRess, MultipartFile file) throws IOException {
        Ressources ressources = getRessourcesById(idRess);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ressources.setImg(fileName);
        saveRessources(ressources);

        String uploadDir = "./src/main/resources/static/img/ressources/" + ressources.getIdRess();
        Path path = Paths.get(uploadDir, fileName);
        Files.write(path, file.getBytes());
    }
    @Override
    public List<Ressources> searchRessourcesByKeyword(String keyword) {
        return ressourcesRepository.searchRessourcesByKeyword(keyword);
    }
    @Override
    public Page<Ressources> getAllRessourcesPaginated(int page, int size) {
        return ressourcesRepository.findAllRessourcesPaginated(PageRequest.of(page, size));
    }
    @Override
    public List<Ressources> getFilteredRessources(Category category, Delivery delivery) {
        return ressourcesRepository.findByCategoryAndDelivery(category, delivery);
    }
    public List<Ressources> getRessourcesByUserId(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
        return ressourcesRepository.findByUser(user);
    }
    public Map<Category, Long> getResourcesAvailableByCategory() {
        List<Ressources> resources = ressourcesRepository.findAll();
        return resources.stream()
                .collect(Collectors.groupingBy(Ressources::getCategory, Collectors.counting()));
    }
    public Double getAverageResourcesPerUser() {
        Long totalResources = ressourcesRepository.count();
        Long totalUsers = userRepository.count();
        return (double) totalResources / totalUsers;
    }
    @Override
    public Category getMostFrequentCategory() {
        List<Ressources> allRessources = ressourcesRepository.findAll();
        Map<Category, Integer> categoryCount = new HashMap<>();

        // Count the number of resources for each category
        for (Ressources ressources : allRessources) {
            Category category = ressources.getCategory();
            if (categoryCount.containsKey(category)) {
                categoryCount.put(category, categoryCount.get(category) + 1);
            } else {
                categoryCount.put(category, 1);
            }
        }

        // Find the category with the highest count
        Category mostFrequentCategory = null;
        int highestCount = 0;
        for (Map.Entry<Category, Integer> entry : categoryCount.entrySet()) {
            if (entry.getValue() > highestCount) {
                mostFrequentCategory = entry.getKey();
                highestCount = entry.getValue();
            }
        }

        return mostFrequentCategory;
    }
    @Override
    public void notifyWhenResourceCountReached(int count) {
        int currentCount = getAllRessources().size();
        if (currentCount >= count) {
            // envoyer une notification par email, sms, etc.
            System.out.println("Le nombre de ressources est atteint !");
        }
    }
    @Override
    public List<Ressources> searchByTitle(String title) {
        List<Ressources> ressources = ressourcesRepository.findByTitleContainingIgnoreCase(title);
        return ressources;
    }



}


