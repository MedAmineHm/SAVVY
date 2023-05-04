package esprit.tn.savvy.repositories;

import esprit.tn.savvy.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RessourcesRepository extends JpaRepository<Ressources, Integer> {



    @Query("select r from Ressources r where r.category = ?1")
    List<Ressources> findByCategory(Category category);

    @Query("SELECT r FROM Ressources r WHERE r.nameRess LIKE %:keyword%")
    List<Ressources> searchRessourcesByKeyword(@Param("keyword") String keyword);
    @Query("SELECT r FROM Ressources r ORDER BY r.idRess DESC")
    Page<Ressources> findAllRessourcesPaginated(PageRequest pageable);
    @Query("SELECT r FROM Ressources r WHERE (:category IS NULL OR r.category = :category) AND (:delivery IS NULL OR r.delivery = :delivery)")
    List<Ressources> findByCategoryAndDelivery(@Param("category") Category category, @Param("delivery") Delivery delivery);

    List<Ressources> findByUser(User user);

    @Query("SELECT r FROM Ressources r WHERE LOWER(r.nameRess) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Ressources> findByTitleContainingIgnoreCase(@Param("title") String title);
    @Query("SELECT r.category, COUNT(r) FROM Ressources r WHERE r.status = 'AVAILABLE' GROUP BY r.category")
    List<Object[]> getResourcesAvailableByCategory();
}


