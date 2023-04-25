package esprit.tn.savvy.entities;

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
    @ManyToOne
    @JoinColumn(name = "idDelivery")
    Delivery delivery;
    Integer quantityRess;
    String img;
    String nameRess;

    @OneToOne
    Reclamation reclamations;

    @ManyToOne
    User user;







    // @ManyToMany(mappedBy = "ressources")
   // List<Delivery> deliveries;


}
