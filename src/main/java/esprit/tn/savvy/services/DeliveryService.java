package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.Ressources;
import esprit.tn.savvy.entities.Status;
import esprit.tn.savvy.entities.User;
import esprit.tn.savvy.repositories.RepDelivery;
import esprit.tn.savvy.repositories.RepRessources;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryService implements IDeliveryService{
    RepDelivery rd;
    RepRessources rr;
    JavaMailSender mailSender;
    IUserService userService;

    @Override
    public Delivery adddelivery(Delivery delivery) {
        return rd.save(delivery);
    }

    @Override
    public List<Delivery> getAllDelivery() {
        return rd.findAll();
    }

    @Override
    public Delivery retrievedelivery(Integer idDelivery) {

        return rd.findById(idDelivery).orElse(null);
    }



    @Override
    public void removedelivery(Delivery delivery) {
        rd.delete(delivery);
        }

    @Override
    public Delivery update(Delivery delivery) {
            Delivery existingDelivery = rd.findById(delivery.getIdDelivery()).get();
            existingDelivery.setDeliveryDate(delivery.getDeliveryDate());
            existingDelivery.setOrigin(delivery.getOrigin());
            existingDelivery.setDestination(delivery.getDestination());
            existingDelivery.setStatus(delivery.getStatus());
            return rd.save(existingDelivery);
        }
    @Override
    public List<Delivery> findByDeliveryDate(Date deliveryDate) {


      return rd.findAll().stream()
                .filter(delivery -> delivery.getDeliveryDate().getTime()==deliveryDate.getTime())
                .collect(Collectors.toList());
    }
    @Override
    public List<Delivery> retrieveDeliveriesByStatus(Status status) {
        return rd.retrieveByStatus(status);

    }
    @Override
    public String getTrackingInformation(Delivery delivery) {
        if (delivery.getStatus() == Status.PENDING) {
            return "Delivery is pending";
        } else if (delivery.getStatus() == Status.IN_PROGRESS) {
            return "Delivery is in transit";
        } else if (delivery.getStatus() == Status.DELIVERED) {
            return "Delivery has been delivered";
        } else {
            return "Delivery status is unknown";
        }
    }

    @Override
    public double calculateDistance(double[] origin, double[] destination) {
        double x1 = origin[0];
        double y1 = origin[1];
        double x2 = destination[0];
        double y2 = destination[1];
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        distance = distance * 111.319;
        return distance;
    }

    @Override
    public Delivery assignDeliveryRessources(Integer idRess, Integer idDelivery) {
        Delivery delivery = rd.findById(idDelivery).orElse(null);
        Ressources ressources = rr.findById(idRess).orElse(null);
        if (delivery != null && ressources != null) {
            List<Ressources> resources = delivery.getRessources();
            resources.add(ressources);
            delivery.setRessources(resources);
            rd.save(delivery);
        }
        return delivery;

    }

    public void sendDeliveryNotification(Delivery delivery) {
        if (delivery.getStatus() == Status.PENDING) {
            User user = userService.findUserById(delivery.getDeliveryPerson().getPersonId());
            if (user != null) {
                String subject = "Delivery Notification";
                String body = "Dear " + user.getEmail() + ",\n\nYour delivery with id " + delivery.getIdDelivery() + " is pending. Please contact us if you have any questions.\n\nBest regards,\nDelivery Service";
                sendEmail(user.getEmail(), subject, body);
            }
        }
}
    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@deliveryservice.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

}
