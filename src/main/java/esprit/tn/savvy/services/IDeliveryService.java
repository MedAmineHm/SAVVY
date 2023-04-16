package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.Status;

import java.util.Date;
import java.util.List;

public interface IDeliveryService {

    Delivery adddelivery(Delivery delivery);

    List<Delivery> getAllDelivery();


    void removedelivery(Delivery delivery);

    Delivery update(Delivery delivery);

    Delivery retrievedelivery(Integer idDelivery);

    List<Delivery> retrieveDeliveriesByStatus(Status status);

    List<Delivery> findByDeliveryDate(Date deliveryDate);
    String getTrackingInformation(Delivery delivery);

    double calculateDistance(double[] origin, double[] destination);

    Delivery assignDeliveryRessources(Integer idRess, Integer idDelivery);
}
