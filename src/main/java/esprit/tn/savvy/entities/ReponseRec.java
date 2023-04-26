package esprit.tn.savvy.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "ReponseRec")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReponseRec implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRep")
    private Integer idRep;
    private String reponse;
    @OneToOne
    private Reclamation reclamation;
}
