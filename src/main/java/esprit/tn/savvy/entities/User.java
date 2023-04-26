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
     @Enumerated(EnumType.STRING)
     Role role;

     String email;


   // @OneToMany(mappedBy = "forum")
    //private Set<Forum> forum ;
}
