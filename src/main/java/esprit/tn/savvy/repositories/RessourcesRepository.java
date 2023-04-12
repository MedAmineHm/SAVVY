package esprit.tn.savvy.repositories;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Ressources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RessourcesRepository extends JpaRepository<Ressources, Integer> {
    @Query("select r from Ressources   r where r.category=?1 ")

    List<Ressources> findByCategory(Category category);

}
