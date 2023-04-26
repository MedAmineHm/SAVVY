package esprit.tn.savvy.repositories;

import esprit.tn.savvy.entities.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository

public interface RepForum extends JpaRepository<Forum,Integer> {
    List<Forum> findByTitleContainingIgnoreCase(String title);
      List<Forum> findByCategory(String category);
    //   List<Forum> findByDate(Date creationDate);

}