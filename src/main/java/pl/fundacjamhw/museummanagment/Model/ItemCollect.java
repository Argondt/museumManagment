package pl.fundacjamhw.museummanagment.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCollect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "items_id")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    private Integer numberOfItemsTaken;
    public ItemCollect(Item item, User user, Integer numberOfItemsTaken) {
        this.item = item;
        this.user = user;
        this.numberOfItemsTaken = numberOfItemsTaken;
    }



}
