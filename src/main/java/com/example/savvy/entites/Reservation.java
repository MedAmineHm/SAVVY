package com.example.savvy.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Reservation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Long idReservation;

    @Temporal(TemporalType.DATE)
    private Date dateRes;
    @JsonIgnore
    @ManyToOne
    private Event event;

    @JsonIgnore
    @ManyToOne
    private User appUser;



}
