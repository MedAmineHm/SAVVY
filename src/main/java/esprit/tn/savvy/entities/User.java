package esprit.tn.savvy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        Role role;
        @OneToMany
        Set<Reclamation> reclamations ;
        @OneToMany(mappedBy = "user")
        @JsonIgnore
        Set<Ressources> ressources;
        @OneToMany
        Set<Donnation> donnations;
        @ManyToMany(mappedBy = "users")
        Set<Event> events;
        @ManyToMany(mappedBy = "users")
        Set<Forum> forums;



        // cy
       /* @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
        public String getfirstname(){
            return username;
        }*/


        /*public User findByUsername(String username) {
        }*/
    }

