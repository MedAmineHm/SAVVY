package com.example.savvy.services;

import com.example.savvy.entites.Event;
import com.example.savvy.entites.Reservation;

import java.util.List;

public interface IReservationService {

    public List<Reservation> getAllReservation();
    public Reservation getReservationById(Long aLong);
    public Reservation createReservation(Reservation reservation,Long aLong,Long idUser);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservation(Long aLong);
}
