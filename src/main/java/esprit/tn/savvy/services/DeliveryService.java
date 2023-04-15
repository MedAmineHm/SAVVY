package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.Status;
import esprit.tn.savvy.repositories.RepDelivery;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryService implements IDeliveryService{
    RepDelivery rd;

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

}
