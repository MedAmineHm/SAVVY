package esprit.tn.savvy.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "Forum")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@ToString
public class Forum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForum")
    Integer idForum;
    String Question;
    String Reponse;
    @OneToMany
    Set<Event> events;
    @ManyToMany
    Set<User> users;


    String content ;
    String title;
    @Enumerated(EnumType.STRING)
    Category category;

   // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "dd-MM-yyyy")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date creationDate ;
    @JsonIgnore
    @OneToMany(mappedBy = "forum",cascade = CascadeType.ALL)
    private List<Comment> commentList;
//@ManyToOne
 //User user ;
}
