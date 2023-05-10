package esprit.tn.savvy.controller;

import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.Status;
import esprit.tn.savvy.entities.User;
import esprit.tn.savvy.services.EmailService;
import esprit.tn.savvy.services.IDeliveryService;
import esprit.tn.savvy.services.IUserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("delivery")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ControllerDelivery {
    IDeliveryService deliveryService;
    IUserService userService;
    EmailService emailService;



    @PostMapping("add")
    public Delivery adddelivery(@RequestBody Delivery delivery) {
        return deliveryService.adddelivery(delivery);
    }

    @GetMapping("findall")
    public List<Delivery> retrieveAllDelivery() {
        return deliveryService.getAllDelivery();
    }

    @GetMapping("{idDelivery}")
    public Delivery retrievebyid(@PathVariable Integer idDelivery) {
        return deliveryService.retrievedelivery(idDelivery);

    }

    @DeleteMapping("{idDelivery}")
    public void removedeliverybyid(@PathVariable Integer idDelivery) {
        Delivery delivery = deliveryService.retrievedelivery(idDelivery);
        if (delivery != null) {
            deliveryService.removedelivery(delivery);
        }

    }
    @PutMapping("{idDelivery}")
    public Delivery updateDelivery(@PathVariable Integer idDelivery, @RequestBody Delivery delivery) {
        delivery.setIdDelivery(idDelivery);
        return deliveryService.update(delivery);
    }

    @GetMapping("getByStatus/{status}")
    public List<Delivery> retrieveDeliveriesByStatus(@PathVariable("status") Status status)
    {
        return deliveryService.retrieveDeliveriesByStatus(status);
    }
    @GetMapping("/byDeliveryDate")
    public List<Delivery> findByDeliveryDate(@RequestParam("deliveryDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date deliveryDate)
    {
        return deliveryService.findByDeliveryDate(deliveryDate);
    }
    @PutMapping("/assign/{idRess}/{idDelivery}")
    public Delivery assignDeliveryRessources(@PathVariable("idRess") Integer idRess, @PathVariable("idDelivery") Integer idDelivery) {
        return deliveryService.assignDeliveryRessources(idRess, idDelivery);
    }


    @GetMapping("/{id}/track")
    public ResponseEntity<?> trackDelivery(@PathVariable("id") Integer deliveryId) {
        Delivery delivery = deliveryService.retrievedelivery(deliveryId);
        if (delivery == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delivery not found");
        } else if (delivery.getStatus() != Status.DELIVERED) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delivery not yet delivered");
        } else {
            String trackingInformation = deliveryService.getTrackingInformation(delivery);
            return ResponseEntity.ok().body(trackingInformation);
        }
    }

    @GetMapping("calculate/{origin}/{destination}")
    public String calculateDistance(@PathVariable("origin") double[] origin,@PathVariable("destination") double[] destination)
    {
        return deliveryService.calculateDistance(origin,destination)+" KM";
    }
    @PostMapping("/notification")
    public ResponseEntity<String> sendDeliveryNotification(@RequestBody Delivery delivery, @RequestParam String email) {
        User user = userService.findUserByEmail(email);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        if (delivery.getStatus() == Status.PENDING) {
            String message = "Dear " + user.getFirstName() + ",\n\n" +
                    "A new delivery is pending and requires your attention. Please check the delivery details and take the necessary actions.\n\n" +
                    "Delivery details:\n" +
                    "Type: " + delivery.getTypeDelivery() + "\n" +
                    "Origin: " + delivery.getOrigin() + "\n" +
                    "Destination: " + delivery.getDestination() + "\n" +
                    "Delivery date: " + delivery.getDeliveryDate() + "\n\n" +
                    "Best regards,\n" +
                    "The Savvy team";
            emailService.sendEmail(user.getEmail(), "New delivery pending", message);
            return ResponseEntity.ok().body("Notification sent successfully");
        } else {
            return ResponseEntity.badRequest().body("Delivery status is not pending");
        }
    }



}