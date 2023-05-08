package com.example.savvy.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Event")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvent")
    private Long idEvent;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private String nomEvent;
    private String description;
    private Integer nbrMaxReservation;
    private String image;



    @JsonIgnore
    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    private List<Reservation> reservationList;

}
