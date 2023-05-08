package esprit.tn.savvy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 52f775271a1b8ceac12a48b41e11ff73a05accf0
import java.util.Set;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    Long idUser;

    String firstName;

    String lastName;

    String email;
    @ManyToMany(mappedBy = "userrr",cascade = CascadeType.ALL)
    private List<Reservation> reservations;


<<<<<<< HEAD
    @OneToMany
    Set<Reclamation> reclamations ;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    Set<Ressources> ressources;
    @OneToMany
    Set<Donnation> donnations;
    @ManyToMany(mappedBy = "userrr")
    Set<Event> events;
    @ManyToMany(mappedBy = "users")
    Set<Forum> forums;
    @OneToOne
    Role roles;

}
=======
   // @OneToMany(mappedBy = "forum")
    //private Set<Forum> forum ;
}
>>>>>>> 52f775271a1b8ceac12a48b41e11ff73a05accf0
