package esprit.tn.savvy.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table( name = "Reclamation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReclamation")
    Integer idReclamation;
    String sujet;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    String contenu;

    @Column(columnDefinition = "Timestamp")
    LocalDateTime daterec;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    User user;

    /*@OneToOne(mappedBy = "reclamation")
    private ReponseRec reponseRec;

     */



}
