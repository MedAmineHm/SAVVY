package com.example.savvy.entites;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "DeliveryPerson")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personId")
    Integer personId;
    String firstNameP;

    String lastNameP;
    Integer NumberP;
    String emailP;

    @OneToMany
    List<Delivery> deliveries;
}