package com.example.savvy.services;

import com.example.savvy.Repository.IEventRepository;
import com.example.savvy.Repository.IReservationRepository;
import com.example.savvy.Repository.IUserRepository;
import com.example.savvy.entites.Event;
import com.example.savvy.entites.Reservation;
import com.example.savvy.entites.User;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements IReservationService{
    @Autowired
    IReservationRepository iReservationRepository;

    @Autowired
    IEventRepository eventRepository;

    @Autowired
    IUserRepository iUserRepository;


    JavaMailSender mailSender;

    @Override
    public List<Reservation> getAllReservation() {
        return iReservationRepository.getall();
    }

    @Override
    public Reservation getReservationById(Long aLong) {
        return iReservationRepository.findById(aLong).get();
    }

    @Override
    public Reservation createReservation(Reservation reservation,Long idevent,Long idUser) {
        log.info("res"+reservation);
        log.info("idevent"+idevent);
        log.info("idUser"+idUser);
            User user=eventRepository.getUserById(idUser);
        log.info("hhhhhh"+user);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Reservation Confirmation");
            message.setFrom("hamza.rbah@esprit.tn");
            message.setText("Dear " + ",\n\n"
                    + "Your reservation for event " +  " on "
                    +  " has been confirmed.\n\n"
                    + "Thank you for using our service.\n\n"
                    + "Best regards,\n"
                    + "The Reservation Team");
        mailSender.send(message);

        reservation.setEvent(eventRepository.findById(idevent).get());
        reservation.setAppUser(iUserRepository.findById(idUser).get());
        reservation.setDateRes(new Date());
        return iReservationRepository.save(reservation);

    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return iReservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long aLong) {
        iReservationRepository.deleteById(aLong);
    }
}
