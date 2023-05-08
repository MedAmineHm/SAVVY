package com.example.savvy.Repository;

import com.example.savvy.entites.Event;
import com.example.savvy.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

   @Query(value = "select r from Reservation r ")
    public List<Reservation> getall();
}
