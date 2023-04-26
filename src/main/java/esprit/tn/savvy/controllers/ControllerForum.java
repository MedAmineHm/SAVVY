package esprit.tn.savvy.controllers;

import esprit.tn.savvy.entities.Category;
import esprit.tn.savvy.entities.Forum;
import esprit.tn.savvy.services.ServiceForum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@EnableJpaRepositories
@RestController
@Slf4j
public class ControllerForum {
@Autowired

    ServiceForum serviceForum;

    @GetMapping("getForumById/{idForum}")
    public Forum getForumById(@PathVariable(value = "idForum") Integer idForum) {
        return serviceForum.getForumById(idForum);
    }

    @GetMapping("/getAllForums")
    public List<Forum> getAllForums() {
        return serviceForum.getAllForums();
    }

    @PostMapping("/add")
    public Forum createForum(@RequestBody Forum forum) {
        return serviceForum.createForum(forum);
    }


    @PutMapping("updateForum/{idForum}")
    public Forum updateForum(@PathVariable(value = "idForum") Integer idForum, @RequestBody Forum forum) {
        return serviceForum.updateForum(idForum, forum);
    }

    @DeleteMapping("deleteForum/{idForum}")
    public void  deleteForum(@PathVariable Integer idForum) {

        serviceForum.deleteForum(idForum);
    }


    @GetMapping("/search")
     public List<Forum> searchForumByTitle(@RequestParam("title")String title) {
        List<Forum> forums=serviceForum.searchByTitle(title) ;
       return forums ;
   }
    @GetMapping("/category")
    public List<Forum> getForumByCategory(@RequestBody Category category){
        log.info("hhh"+category);
if(category !=null)
        return  serviceForum.getForumsByCategory(category);
return null;
    }
    @GetMapping("/date")
    public List<Forum> getForumsByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")Date date) {
      List<Forum> forums = serviceForum.getForumsByDate(date);
        if (forums.isEmpty()) {
           return forums;
       }
        return forums ;
    }
}
