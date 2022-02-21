package pl.fundacjamhw.museummanagment.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int numberOfItems;

    public Item(String name, int numberOfItems) {
        this.name = name;
        this.numberOfItems = numberOfItems;
    }
}
