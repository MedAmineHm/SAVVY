package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Comment;
import esprit.tn.savvy.entities.Forum;
import esprit.tn.savvy.repositories.CommentRepository;
import esprit.tn.savvy.repositories.ForumRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;
@Service

public class CommentServiceImpl implements ICommentService {
@Autowired
    CommentRepository commentRepository ;
@Autowired
    ForumRepository forumRepository ;
    @Override
    public Comment getCommentById(Integer idComment) {
        return commentRepository.findById(idComment).get();
    }

    @Override
    public List<Comment> getAllComments() {
         return commentRepository.findAll();
    }

    @Override
    public Comment createComment(Comment comment , Integer idForum) {
        Forum forum = forumRepository.findById(idForum).orElse(null) ;
        if(forum != null) {
            String commentText = comment.getDescription();
            List<String> badWords = Arrays.asList("mot1", "mot2", "mot3");
            boolean hasBadWords = badWords.stream().anyMatch(commentText::contains);
            if (hasBadWords) {
                // si le commentaire contient des bad words, ne pas l'enregistrer et retourner null
                return null;
            }}
            comment.setForum(forum);
            commentRepository.save(comment);
            return comment ;
    }
       /* @Override
    public Comment updateComment( Comment comment , Integer idForum)  {
            Forum forum1 = forumRepository.findById(idForum).orElse(null) ;
            if(forum1 !=null) {
                comment.setForum(forum1) ;
                commentRepository.save(comment);
            }
        }
        return comment ;
    }
*/
    @Override
    public Comment updateComment(Comment comment, Integer idForum) {
        Forum forum1 = forumRepository.findById(idForum).orElse(null) ;
        if(forum1 !=null) {
            comment.setForum(forum1) ;
            commentRepository.save(comment);
        }
        return comment ;
    }




    @Override
    public void deleteComment(Integer idComment) {
        commentRepository.deleteById(idComment);

    }

    @Override
    public List<Comment> getCommentsByForum(Forum forum) {
        return commentRepository.findByForum(forum);
    }
}
