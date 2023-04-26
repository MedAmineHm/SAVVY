package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Forum;
import esprit.tn.savvy.repositories.RepForum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceForum implements IServiceForum {

    RepForum repForum ;

    @Override
    public Forum getForumById(Integer idForum) {
        return repForum.findById(idForum).get();
    }

    @Override
    public List<Forum> getAllForums() {
        List<Forum> f = repForum.findAll() ;
        return f ;
    }

    @Override
    public Forum createForum(Forum forum) {
        return repForum.save(forum);
    }
// update il 5ra
    @Override
    public Forum updateForum(Integer idForum, Forum forum) {
        Forum forums = repForum.findById(idForum).get();
       // forum.setQuestion(forum.getQuestion());
        //forum.setReponse(forum.getReponse());
        //forum.setContent(forum.getContent());
        //forum.setTitle(forum.getTitle());
        //forum.setCreationDate(forum.getCreationDate());

        Forum updatedForum = repForum.save(forum) ;

        return updatedForum;
    }

    @Override
    public void deleteForum(Integer idForum) {
        repForum.deleteById(idForum);

    }

    @Override
    public List<Forum> searchByTitle(String title) {
       return repForum.findByTitleContainingIgnoreCase(title);
    }

   @Override
    public List<Forum> getForumsByCategory(Category category) {
        return repForum.findByCategory(category);
    }

   @Override
    public List<Forum> getForumsByDate(Date creationDate) {
        return repForum.findByDate(creationDate);
    }
}


