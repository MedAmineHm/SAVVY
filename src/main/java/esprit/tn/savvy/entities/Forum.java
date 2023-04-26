package esprit.tn.savvy.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Forum")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Forum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForum")
    Integer idForum;
    String Question;
    String Reponse;
    String content ;
    String title;

    @Temporal(TemporalType.DATE)
    private Date creationDate ;
}
