package esprit.tn.savvy.repositories;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Ressources;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RessourcesRepository extends JpaRepository<Ressources, Integer> {
    List<Ressources> findByCategory(Category category);

}
