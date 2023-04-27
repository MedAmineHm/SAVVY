package esprit.tn.savvy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter


public class Comment {
    @Column(name = "comments")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComment;

    //@Column(nullable = false)
    private String content ;
    private String description ;
    //@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @JsonIgnore
    @ManyToOne
    private Forum forum;
}
