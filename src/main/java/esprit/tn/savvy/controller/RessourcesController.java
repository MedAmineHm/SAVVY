package esprit.tn.savvy.controller;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.Ressources;
import esprit.tn.savvy.services.RessourcesService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ressources")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RessourcesController {
    @Autowired
    private RessourcesService ressourcesService;


    @GetMapping("/findall")
    public List<Ressources> getAllRessources() {
        return ressourcesService.getAllRessources();
    }

    @GetMapping("/{id}")
    public Ressources getRessourcesById(@PathVariable(name="id") Integer idRess) {
        return ressourcesService.getRessourcesById(idRess);
    }

    @PostMapping("add")
    public Ressources createRessources(@RequestBody Ressources ressources) {
        return ressourcesService.createRessources(ressources);
    }

    @PutMapping("/{idRess}")
    public Ressources updateRessources(@PathVariable Integer idRess, @RequestBody Ressources ressources) {
        return ressourcesService.updateRessources(idRess, ressources);
    }

    @DeleteMapping("/{id}")
    public void deleteRessources(@PathVariable(name = "id") Integer idRess) {
        ressourcesService.deleteRessources(idRess);
    }



    @PostMapping("/ressources/{idRess}/users/{idUser}")
    public Ressources assignUserToRessources(@PathVariable Integer idRess, @PathVariable Integer idUser) {
        return ressourcesService.assignUserToRessources(idUser, idRess);
    }
    @GetMapping("/category/{category}")
    public List<Ressources> findRessourcesByCategory(@PathVariable Category category) {
        return ressourcesService.findRessourcesByCategory(category);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveRessources(@RequestBody Ressources ressources) {
        try {
            ressourcesService.saveRessources(ressources);
            return ResponseEntity.ok("Ressources saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save ressources.");
        }
    }
    @PostMapping("/{idRess}/img")
    public ResponseEntity<?> addImageToRessources(@PathVariable Integer idRess, @RequestParam("img") MultipartFile file) {
        try {
            ressourcesService.addImageToRessources(idRess, file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }



        @GetMapping("/search")
        public List<Ressources> searchRessourcesByKeyword(@RequestParam("keyword") String keyword) {
            return ressourcesService.searchRessourcesByKeyword(keyword);
        }
    @GetMapping("/paginated")
    public Page<Ressources> getAllRessourcesPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ressourcesService.getAllRessourcesPaginated(page, size);
    }
    @GetMapping("/filtered")
    public List<Ressources> getFilteredRessources(@RequestParam(name = "category", required = false) Category category,
                                                  @RequestParam(name = "delivery", required = false) Delivery delivery) {
        return ressourcesService.getFilteredRessources(category, delivery);
    }
    @GetMapping("/users/{idUser}")
    public List<Ressources> getRessourcesByUserId(@PathVariable Integer idUser) {
        return ressourcesService.getRessourcesByUserId(idUser);
    }
    @GetMapping("/resources/stats/available")
    public Map<Category, Long> getResourcesAvailableByCategory() {
        return ressourcesService.getResourcesAvailableByCategory();
    }
    @GetMapping("/verage-resources-per-user")
    public ResponseEntity<Double> getAverageResourcesPerUser() {
        Double averageResourcesPerUser = ressourcesService.getAverageResourcesPerUser();
        return ResponseEntity.ok(averageResourcesPerUser);
    }
    @GetMapping("/Most-frequent-category")
    public Category getMostFrequentCategory() {
        return ressourcesService.getMostFrequentCategory();
    }
    @GetMapping("/check-resource-count/{count}")
    public ResponseEntity<String> checkResourceCount(@PathVariable int count) {
        ressourcesService.notifyWhenResourceCountReached(count);
        return ResponseEntity.ok("Check resource count successful");
    }
    @GetMapping("/search/title")
    public ResponseEntity<List<Ressources>> searchByTitle(@RequestParam String title) {
        List<Ressources> ressources = ressourcesService.searchByTitle(title);
        if (ressources.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(ressources);
        }
    }

}





