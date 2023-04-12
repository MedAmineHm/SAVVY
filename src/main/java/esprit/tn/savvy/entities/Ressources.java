package esprit.tn.savvy.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "Ressources")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ressources implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRess")
    Integer idRess;
    String name;
@Enumerated(EnumType.STRING)
    Category category;
    Integer quantityRess;
    String img;

   @OneToOne
    Reclamation reclamations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
    @ManyToMany(mappedBy = "ressources")
     List<Delivery> deliveries;

}
