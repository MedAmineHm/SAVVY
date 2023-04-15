package esprit.tn.savvy.repositories;

import esprit.tn.savvy.entities.Delivery;
import esprit.tn.savvy.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepDelivery extends JpaRepository<Delivery,Integer> {
    @Query("select d from Delivery d where d.status = ?1")
    List<Delivery> retrieveByStatus(Status status);

}
