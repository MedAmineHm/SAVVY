package esprit.tn.savvy.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/*public enum Role {
    PARTNER, ADMIN, SIMPLE_USER
}*/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Role")
public class Role  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roleId")
    private Long roleId;
    @Column(length = 60)
    private String name;
}