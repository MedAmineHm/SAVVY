package esprit.tn.savvy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Event")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvent")
    private Long idEvent;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String nomEvent;
    private String description;
    private Integer nbrMaxReservation;
    @JsonIgnore
    @ManyToMany
    Set<User> userrr;

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    Set<Reservation> reservations;

}
