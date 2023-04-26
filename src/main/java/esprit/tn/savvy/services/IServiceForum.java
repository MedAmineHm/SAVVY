package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Forum;

import java.util.Date;
import java.util.List;

public interface IServiceForum {
    public Forum getForumById (Integer idForum) ;
    List<Forum> getAllForums() ;
    public Forum createForum(Forum forum) ;
    public Forum updateForum (Integer idForum ,Forum forum) ;
    public void deleteForum(Integer idForum);
    List<Forum> searchByTitle(String title) ;
    List<Forum> getForumsByCategory(Category category) ;
    List<Forum> getForumsByDate(Date date) ;
}
