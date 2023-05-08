package com.example.savvy.Controller;

import com.example.savvy.entites.Reservation;
import com.example.savvy.services.ReservationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
public class ReservationController {

    @Autowired
    ReservationServiceImpl reservationService;

    @GetMapping("/GetAllReservation")
    public List<Reservation> getAllReservation(){
        return reservationService.getAllReservation();
    }

    @PostMapping("/addReservation/{idEvent}/{idUser}")
    public Reservation addReservation(@RequestBody Reservation reservation,@PathVariable("idEvent") Long idevent,@PathVariable("idUser") Long idUser){

        return reservationService.createReservation(reservation,idevent,idUser);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteInteraction(@PathVariable("id") Long id){
        reservationService.deleteReservation(id);
    }

    @GetMapping("/Reservation/{id}")
    public Reservation getReservationById(@PathVariable("id") Long id){
        return reservationService.getReservationById(id);
    }

    @PostMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation  reservation){
        return reservationService.updateReservation(reservation);
    }
}
