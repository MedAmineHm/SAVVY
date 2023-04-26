package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Reservation;

import java.util.List;

public interface IserviceReservation {
    Reservation makeReservation(Long idEvent, Long idUser);

    List<Reservation> getReservationsByUserId(Long idUser);
}
