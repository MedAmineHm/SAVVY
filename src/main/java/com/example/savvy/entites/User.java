package com.example.savvy.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    Long idUser;

    String firstName;

    String lastName;

    String email;

    @OneToMany
    Set<Reclamation> reclamations ;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    Set<Ressources> ressources;
    @OneToMany
    Set<Donnation> donnations;




    @JsonIgnore
    @OneToMany(mappedBy = "appUser",cascade = CascadeType.ALL)
    private List<Reservation> reservationList;

    @ManyToMany(mappedBy = "users")
    Set<Forum> forums;
    @OneToOne
    Role roles;

}