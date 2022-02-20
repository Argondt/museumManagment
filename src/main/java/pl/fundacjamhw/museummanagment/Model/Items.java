package pl.fundacjamhw.museummanagment.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    @Id
    private Long id;
    private String name;
    private int numberOfItems;

}
