package esprit.tn.savvy.repsitory;

import esprit.tn.savvy.entities.ReponseRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseRecRepository extends JpaRepository<ReponseRec, Integer> {




}
