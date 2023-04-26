package esprit.tn.savvy.services;

import esprit.tn.savvy.Repository.EventRepository;
import esprit.tn.savvy.Repository.ReservationRepository;
import esprit.tn.savvy.entities.Event;
import esprit.tn.savvy.entities.Reservation;
import esprit.tn.savvy.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@AllArgsConstructor
@Service
public class ReservationService implements IserviceReservation{
    private ReservationRepository  reservationRepository;
    private EventRepository eventRepository;

    private JavaMailSender mailSender;


    public Reservation makeReservation(Long idEvent, Long idUser) {
        Long eventId = eventRepository.getEventById(idEvent);
        User user = eventRepository.getUserById(idUser);

        Reservation reservation = new Reservation();
        reservation.setIdEventt(eventId);
        reservation.setIdUser(user.getIdUser());
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByUserId(Long idUser) {
        return reservationRepository.getUserFromReservation(idUser);
    }

    public void sendConfirmationEmail(User user, Reservation reservation) {
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
    }


}



