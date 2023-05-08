package esprit.tn.savvy.controllers;

import esprit.tn.savvy.entities.Comment;
import esprit.tn.savvy.entities.Forum;
import esprit.tn.savvy.repositories.CommentRepository;
import esprit.tn.savvy.services.CommentServiceImpl;
import esprit.tn.savvy.services.ForumServiceImpl;
import esprit.tn.savvy.services.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin("*")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    ForumServiceImpl forumService;
    @GetMapping("getCommentById/{idComment}")
    public Comment getCommentById(@PathVariable("idComment") Integer idComment) {
        return   commentService.getCommentById(idComment);

    }

    @GetMapping("getAllComments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();

    }

    @PostMapping("create/{idForum}")
    public Comment createComment(@RequestBody Comment comment , @PathVariable Integer idForum) {
        Date date=new Date();
        comment.setCreationDate(date);
        Comment newComment = commentService.createComment(comment, idForum) ;
        return newComment ;
    }

    @PutMapping("update/{idForum}")
    public Comment updateComment(@RequestBody Comment comment , @PathVariable Integer idForum) {
     Comment updateComment = commentService.updateComment(comment , idForum);
     return comment ;
     }


    @DeleteMapping("delete/{idComment}")
     void deleteComment (@PathVariable("idComment") Integer idComment) {
        commentService.deleteComment(idComment);
    }

    @GetMapping("forum/{idForum}")
    public List<Comment> getCommentsByForum(@PathVariable("idForum") Integer idForum) {
        Forum forum = forumService.getForumById(idForum) ;
        return  commentService.getCommentsByForum(forum);
    }

}
