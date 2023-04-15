package esprit.tn.savvy.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@ToString

@Table(name = "User", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Long UserId;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String address;
    @Temporal (TemporalType.DATE)
    private Date dayOfBirth;
    private String token;
    private String cin;
    private String telNum;
     /*@Enumerated(EnumType.STRING)
     Role role;*/
     @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinTable(name = "user_roles",
             joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
     private Set<Role> roles;

}
