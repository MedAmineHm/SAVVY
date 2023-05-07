package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.DeliveryPerson;
import esprit.tn.savvy.repositories.RepDelivery;
import esprit.tn.savvy.repositories.RepDeliveryPerson;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryPersonService implements IDeliveryPersonService {
    RepDeliveryPerson rdp;
    RepDelivery rd;

    @Override
    public DeliveryPerson adddeliveryperson(DeliveryPerson deliveryPerson) {
        return rdp.save(deliveryPerson);
    }

    @Override
    public List<DeliveryPerson> getAllDeliveryPerson() {
        return rdp.findAll();
    }

    @Override
    public DeliveryPerson retrievedeliveryperson(Integer idPerson) {
        return rdp.findById(idPerson).orElse(null);
    }

    @Override
    public void removedeliveryperson(DeliveryPerson deliveryPerson) {
        rdp.delete(deliveryPerson);
    }

    @Override
    public DeliveryPerson update(DeliveryPerson deliveryPerson) {
        DeliveryPerson existingDeliveryPerson = rdp.findById(deliveryPerson.getPersonId()).get();
        existingDeliveryPerson.setPersonId(deliveryPerson.getPersonId());
        existingDeliveryPerson.setEmailP(deliveryPerson.getEmailP());
        existingDeliveryPerson.setNumberP(deliveryPerson.getNumberP());
        existingDeliveryPerson.setLastNameP(deliveryPerson.getLastNameP());
        existingDeliveryPerson.setFirstNameP(deliveryPerson.getFirstNameP());
        return rdp.save(existingDeliveryPerson);

    }

    @Override
    public DeliveryPerson assignDeliveryToDeliveryPerson(Integer idPerson, Integer idDelivery) {
        DeliveryPerson deliveryPerson = rdp.findById(idPerson).orElse(null);
        Delivery delivery = rd.findById(idDelivery).orElse(null);
        if (deliveryPerson != null && delivery != null) {
            delivery.setDeliveryPerson(deliveryPerson);
            deliveryPerson.getDeliveries().add(delivery);
            rd.save(delivery);
        }
        return deliveryPerson;
    }



    @Override
    public List<DeliveryPerson> getAvailable() {
        List<DeliveryPerson> deliveryPersons = rdp.findAll();
        List<DeliveryPerson> availableDeliveryPersons = new ArrayList<>();
        for (DeliveryPerson deliveryPerson : deliveryPersons) {
            if (deliveryPerson.getDeliveries().size() < 5) {
                availableDeliveryPersons.add(deliveryPerson);
            }
        }
        return availableDeliveryPersons;
    }
    /*
    @Override
    public DeliveryPerson assignDeliveryToDeliveryPersonAvailable(Integer idDelivery) {
        Delivery delivery = rd.findById(idDelivery).orElse(null);
        if (delivery != null) {
            List<DeliveryPerson> availableDeliveryPersons = getAvailable();
            if (availableDeliveryPersons.isEmpty()) {
                throw new RuntimeException("No available delivery person");
            } else {
                DeliveryPerson deliveryPerson = availableDeliveryPersons.get(0);
                delivery.setDeliveryPerson(deliveryPerson);
                deliveryPerson.getDeliveries().add(delivery);
                rdp.save(deliveryPerson);
                return deliveryPerson;
            }
        } else {
            throw new RuntimeException("Delivery not found");
        }
    }

     */

    }




