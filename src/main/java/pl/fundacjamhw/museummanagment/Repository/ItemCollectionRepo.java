package pl.fundacjamhw.museummanagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fundacjamhw.museummanagment.Model.ItemCollect;

public interface ItemCollectionRepo extends JpaRepository<ItemCollect,Long> {
}
