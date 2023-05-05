package esprit.tn.savvy.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import esprit.tn.savvy.entities.Reclamation;
import esprit.tn.savvy.services.IReclamationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/reclamations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationController {

    IReclamationService reclamationService;
    public ReclamationController(IReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @PostMapping("/addrec")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }

    @PutMapping("/mod/{idReclamation}")
    public Reclamation updateReclamation(@PathVariable Integer idReclamation, @RequestBody Reclamation reclamation) {
        reclamation.setIdReclamation(idReclamation);
        return reclamationService.updateReclamation(reclamation);
    }

    @GetMapping("/get/{idReclamation}")
    public Reclamation retrieveReclamation(@PathVariable Integer idReclamation) {
        return reclamationService.retrieveReclamation(idReclamation);
    }

    @GetMapping("/affrec")
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getAllReclamations();
    }
    @DeleteMapping("/del/{idReclamation}")
    public void removeReclamation(@PathVariable Integer idReclamation) {

        reclamationService.removeReclamation(idReclamation);
    }


    @GetMapping("/count-by-state")
    public Map<String, Long> getReclamationsCountByState() {
        return reclamationService.getReclamationsCountByState();
    }




  /* @GetMapping("/recherche/{sujet}")


    public List<Reclamation> findBySujet(@PathVariable("sujet") String sujet ){
        return reclamationService.findReclamationBysujet(sujet);
    }


   */




    @GetMapping("/recherche")
    public List<Reclamation> advancedSearch(
            @RequestParam(name = "sujet", required = false) String sujet,
            @RequestParam(name = "etat", required = false) String etat,
            @RequestParam(name = "contenu", required = false) String contenu,
            @RequestParam(name = "date_rec", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime daterec) {

        // Call the service method with the new parameter
        return reclamationService.advancedSearch(sujet, etat, contenu, daterec);
    }








}







