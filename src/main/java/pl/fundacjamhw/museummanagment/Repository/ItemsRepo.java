package pl.fundacjamhw.museummanagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fundacjamhw.museummanagment.Model.Item;

@Repository
public interface ItemsRepo extends JpaRepository<Item,Long> {
    Item findItemsById(Long id);
    Item getItemById(Long id);


}
