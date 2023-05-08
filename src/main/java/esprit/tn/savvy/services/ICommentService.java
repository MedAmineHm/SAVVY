package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Comment;
import esprit.tn.savvy.entities.Forum;

import java.util.List;

public interface ICommentService {
    Comment getCommentById(Integer idComment);
    List<Comment> getAllComments();
    Comment createComment(Comment comment , Integer idForum);
    Comment updateComment( Comment comment , Integer idForum) ;

    void deleteComment(Integer idComment);
    List<Comment> getCommentsByForum(Forum forum);

}
