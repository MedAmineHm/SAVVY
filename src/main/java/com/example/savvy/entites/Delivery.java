package com.example.savvy.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Delivery")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delivery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDelivery")
    Integer idDelivery;
    String typeDelivery;
    String origin;
    String destination;

    @Temporal(TemporalType.DATE)
    Date deliveryDate;
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne
    @JsonIgnore
    DeliveryPerson deliveryPerson;

    @ManyToMany
    List<Ressources> ressources;


}
