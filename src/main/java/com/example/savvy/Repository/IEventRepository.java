package com.example.savvy.Repository;

import com.example.savvy.entites.Event;
import com.example.savvy.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {


    @Query("SELECT e.idEvent FROM Event e WHERE e.idEvent =:idEvent")
    Long getEventById(@PathParam("idEvent") Long idEvent);
    @Query("select u from User u where u.idUser =:idUser")
    User getUserById(@PathParam("idUser") Long idUser);


    @Query("SELECT e FROM Event e WHERE e.dateDebut >= :startDate AND e.dateFin <= :endDate")
    List<Event> findEventsBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);



}
