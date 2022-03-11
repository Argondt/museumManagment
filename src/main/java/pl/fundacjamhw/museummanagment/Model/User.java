package pl.fundacjamhw.museummanagment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data

@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    private String password;
    private String firstName;
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    public User() {
    }
    public User(String username, String email, String password,String firstName,String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName=firstName;
        this.lastName=lastName;
    }

}