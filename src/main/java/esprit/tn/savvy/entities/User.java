package esprit.tn.savvy.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
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

     String email;
     @OneToMany(mappedBy = "users")
     Set<Reclamation> reclamations ;
     @OneToMany(mappedBy = "users")
    Set<Ressources> ressources;
     @OneToMany(mappedBy = "users")
    Set<Donnation> donnations;
     @OneToMany(mappedBy = "users")
    Set<Event> events;
     @ManyToMany(mappedBy = "users")
    Set<Forum> forums;
     @OneToOne(mappedBy = "users")
    Set<Role>roles;
     @OneToMany(mappedBy = "users")
    Set<Delivery>deliveries;

}
