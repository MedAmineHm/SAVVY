package esprit.tn.savvy.controller;

import esprit.tn.savvy.entities.DeliveryPerson;
import esprit.tn.savvy.services.IDeliveryPersonService;
import esprit.tn.savvy.services.IDeliveryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deliveryperson")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ControllerDeliveryPerson {
    IDeliveryPersonService deliveryPersonService;
    IDeliveryService deliveryService;
    @PostMapping("add")
    public DeliveryPerson adddeliveryperson(@RequestBody DeliveryPerson deliveryPerson) {
        return deliveryPersonService.adddeliveryperson(deliveryPerson);
    }
    @GetMapping("findall")
    public List<DeliveryPerson> retrieveAllDeliveryPerson() {
        return deliveryPersonService.getAllDeliveryPerson();
    }
    @GetMapping("{idPerson}")
    public DeliveryPerson retrievebyid(@PathVariable Integer idPerson) {
        return deliveryPersonService.retrievedeliveryperson(idPerson);

    }
    @DeleteMapping("{idPerson}")
    public void removedeliverybyid(@PathVariable Integer idPerson) {
        DeliveryPerson deliveryPerson = deliveryPersonService.retrievedeliveryperson(idPerson);
        if (deliveryPerson != null) {
            deliveryPersonService.removedeliveryperson(deliveryPerson);
        }
    }
    @PutMapping("{idPerson}")
    public DeliveryPerson updateDeliveryPerson(@PathVariable Integer idPerson, @RequestBody DeliveryPerson deliveryPerson) {
        deliveryPerson.setPersonId(idPerson);
        return deliveryPersonService.update(deliveryPerson);
    }
    @PutMapping("assign/{idDelivery}/{idPerson}")
    public DeliveryPerson assignDeliveryPersonToDelivery(@PathVariable("idPerson") Integer idPerson, @PathVariable("idDelivery") Integer idDelivery) {
        return deliveryPersonService.assignDeliveryToDeliveryPerson(idPerson, idDelivery);
    }
    @GetMapping("/available")
    public List<DeliveryPerson> getAvailableDeliveryPerson() {
        return deliveryPersonService.getAvailableDeliveryPerson();
    }


    @GetMapping("/availablePerson")
    public ResponseEntity<?> getAvailable() {
        List<DeliveryPerson> availableDeliveryPersons = deliveryPersonService.getAvailable();
        if (availableDeliveryPersons.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No available delivery person");
        } else {
            return ResponseEntity.ok().body(availableDeliveryPersons);
        }
    }


    @PutMapping("/{idPerson}/deliveries/{idDelivery}")
    public ResponseEntity<?> assignDeliveryToDeliveryPersonAvailable(@PathVariable("idPerson") Integer idPerson, @PathVariable("idDelivery") Integer idDelivery) {
        try {
            DeliveryPerson deliveryPerson = deliveryPersonService.assignDeliveryToDeliveryPersonAvailable(idDelivery);
            return ResponseEntity.ok().body(deliveryPerson);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
