package esprit.tn.savvy.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Delivery")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delivery implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idDelivery")
Integer idDelivery;
String typeDelivery;



}
