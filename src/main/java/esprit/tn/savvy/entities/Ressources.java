package esprit.tn.savvy.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
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
@Enumerated(EnumType.STRING)
    Category category;
    Integer quantityRess;
    String img;

   @OneToOne(mappedBy = "ressources")
    Set<Reclamation> reclamations;
   @OneToOne(mappedBy = "ressources")
    Set<Delivery>deliveries;
}
