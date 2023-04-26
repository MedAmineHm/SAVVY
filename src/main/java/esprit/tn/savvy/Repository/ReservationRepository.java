package esprit.tn.savvy.Repository;

import esprit.tn.savvy.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(value = "select r from Reservation r where r.idUser=?1")
    public List<Reservation> getUserFromReservation(Long idUser);
}
