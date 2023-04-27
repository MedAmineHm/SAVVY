package esprit.tn.savvy.repositories;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<Forum,Integer> {
     List<Forum> findByTitleContainingIgnoreCase(String title);


      List<Forum> findByCategory(Category category);
     // List<Forum> findByDate(Date creationDate);
}
