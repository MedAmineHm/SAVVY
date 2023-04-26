package esprit.tn.savvy.controller;

import esprit.tn.savvy.Repository.EventRepository;
import esprit.tn.savvy.entities.Reservation;
import esprit.tn.savvy.entities.User;
import esprit.tn.savvy.services.IserviceReservation;
import esprit.tn.savvy.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class ReservationController {
    IserviceReservation iserviceReservation;
    private ReservationService reservationService;
    EventRepository eventRepository;


    @PostMapping("/make/{eventId}/{idUser}")
    public ResponseEntity<Reservation> makeReservation(@PathVariable Long eventId, @PathVariable Long idUser) {
        Reservation reservation = reservationService.makeReservation(eventId, idUser);
        return ResponseEntity.ok(reservation);
    }


    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable Long idUser) {
        List<Reservation> reservations = iserviceReservation.getReservationsByUserId(idUser);
        return ResponseEntity.ok(reservations);
    }

    @PostMapping("/confirmReservation/{eventId}/{userId}")
    public ResponseEntity<Reservation> confirmReservation(@PathVariable Long eventId, @PathVariable Long userId) {
        Reservation reservation = reservationService.makeReservation(eventId, userId);
        User user = eventRepository.getUserById(userId);
        reservationService.sendConfirmationEmail(user, reservation);
        return ResponseEntity.ok(reservation);
    }
}
