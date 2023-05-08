package esprit.tn.savvy.controllers;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Forum;
import esprit.tn.savvy.services.ForumServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RequestMapping
@RestController
@Slf4j
@CrossOrigin("*")
public class ControllerForum {
@Autowired
    ForumServiceImpl forumService;

    @GetMapping("getForumById/{idForum}")
    public Forum getForumById(@PathVariable(value = "idForum") Integer idForum) {
        return forumService.getForumById(idForum);
    }

    @GetMapping("/getAllForums")
    public List<Forum> getAllForums() {
        return forumService.getAllForums();
    }

    @PostMapping("/add")
    public Forum createForum(@RequestBody Forum forum) {
        Date  date=new Date();
        forum.setCreationDate(date);
        return forumService.createForum(forum);
    }


    @PutMapping("updateForum")
    public Forum updateForum(@RequestBody Forum forum) {
       // log.info("hhh"+forum);
        return forumService.updateForum(forum);
    }

    @DeleteMapping("deleteForum/{idForum}")
    public void  deleteForum(@PathVariable Integer idForum) {

        forumService.deleteForum(idForum);
    }


    @GetMapping("/search")
     public List<Forum> searchForumByTitle(@RequestParam("title")String title) {
        List<Forum> forums=forumService.searchByTitle(title) ;
       return forums ;
   }
    @GetMapping("/category/{category}")
    public List<Forum> getForumByCategory(@PathVariable("category") Category category){
        if(category !=null)
        return  forumService.getForumsByCategory(category);
       return null;
    }
/*
    @GetMapping("/date")
    public List<Forum> getForumsByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date creationDate) {
      List<Forum> forums = forumService.getForumsByDate(creationDate);
        if (forums.isEmpty()) {
           return forums;
       }
        return forums ;
    }*/
}
