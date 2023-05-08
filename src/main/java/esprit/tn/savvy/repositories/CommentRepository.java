package esprit.tn.savvy.repositories;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Comment;
import esprit.tn.savvy.entities.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Integer> {
    List<Comment> findByForum(Forum forum);
}
