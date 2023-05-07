package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.DeliveryPerson;

import java.util.List;

public interface IDeliveryPersonService {
    DeliveryPerson adddeliveryperson(DeliveryPerson deliveryPerson);

    List<DeliveryPerson> getAllDeliveryPerson();

    DeliveryPerson retrievedeliveryperson(Integer idPerson);

    void removedeliveryperson(DeliveryPerson deliveryPerson);

    DeliveryPerson update(DeliveryPerson deliveryPerson);

    DeliveryPerson assignDeliveryToDeliveryPerson(Integer idPerson, Integer idDelivery);




    List<DeliveryPerson> getAvailable();
   /* DeliveryPerson assignDeliveryToDeliveryPersonAvailable(Integer idDelivery);

    */

}