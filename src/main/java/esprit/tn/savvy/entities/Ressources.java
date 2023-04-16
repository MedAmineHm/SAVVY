package esprit.tn.savvy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

   @OneToOne
    Reclamation reclamations;
   @ManyToMany(mappedBy = "ressources")
   @JsonIgnore
List<Delivery> deliveries;

   @ManyToOne
    User user;
}
