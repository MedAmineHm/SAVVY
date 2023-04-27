package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Forum;
import esprit.tn.savvy.repositories.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ForumServiceImpl implements IServiceForum {
    @Autowired
    ForumRepository forumRepository;
    @Override
    public Forum getForumById(Integer idForum) {
        return forumRepository.findById(idForum).get();
    }

    @Override
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    @Override
    public Forum createForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public Forum updateForum(Forum forum) {
       // Forum forums = forumRepository.findById(idForum).get();
        // forum.setQuestion(forum.getQuestion());
        //forum.setReponse(forum.getReponse());
        //forum.setContent(forum.getContent());
        //forum.setTitle(forum.getTitle());
        //forum.setCreationDate(forum.getCreationDate());

       // Forum updatedForum = forumRepository.save(forum) ;

        return forumRepository.save(forum) ;
    }

    @Override
    public void deleteForum(Integer idForum) {
        forumRepository.deleteById(idForum);
    }
      @Override
    public List<Forum> searchByTitle(String title) {
       return forumRepository.findByTitleContainingIgnoreCase(title);
    }

   @Override
    public List<Forum> getForumsByCategory(Category category) {
        return forumRepository.findByCategory(category);
    }
/*
   @Override
    public List<Forum> getForumsByDate(Date creationDate) {
        return forumRepository.findByDate(creationDate);
    }*/
}
