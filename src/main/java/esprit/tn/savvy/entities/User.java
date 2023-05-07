package esprit.tn.savvy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
     Integer idUser;
     String firstName;
    String lastName;
     String username;
     String email;
     String password;
     String address;
    @Temporal (TemporalType.DATE)
     Date dayOfBirth;
     String token;

    String telNum;
    @Enumerated(EnumType.STRING)
    Role role;
     @OneToMany
     Set<Reclamation> reclamations ;
     @OneToMany(mappedBy = "user")
     @JsonIgnore
    Set<Ressources> ressources;
     @OneToMany
    Set<Donnation> donnations;
     @ManyToMany(mappedBy = "users")
    Set<Event> events;
     @ManyToMany(mappedBy = "users")
     Set<Forum> forums;


}
