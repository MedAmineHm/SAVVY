package esprit.tn.savvy.controller;

import esprit.tn.savvy.entities.Ressources;
import esprit.tn.savvy.services.RessourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class RessourcesController {
    @Autowired
    private RessourcesService ressourcesService;

    @GetMapping
    public List<Ressources> getAllRessources() {
        return ressourcesService.getAllRessources();
    }

    @GetMapping("/{id}")
    public Ressources getRessourcesById(@PathVariable Integer idRess) {
        return ressourcesService.getRessourcesById(idRess);
    }

    @PostMapping
    public Ressources createRessources(@RequestBody Ressources ressources) {
        return ressourcesService.createRessources(ressources);
    }

    @PutMapping("/{id}")
    public Ressources updateRessources(@PathVariable Integer idRess, @RequestBody Ressources ressources) {
        return ressourcesService.updateRessources(idRess, ressources);
    }

    @DeleteMapping("/{id}")
    public void deleteRessources(@PathVariable Integer idRess) {
        ressourcesService.deleteRessources(idRess);
    }




}