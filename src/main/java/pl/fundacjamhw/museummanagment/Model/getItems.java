package pl.fundacjamhw.museummanagment.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class getItems {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "items_id")
    private Items items;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
    private String item;
    private boolean taken;
    private Integer takenSize;

}
