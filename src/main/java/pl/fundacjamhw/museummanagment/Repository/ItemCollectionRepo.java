package pl.fundacjamhw.museummanagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.fundacjamhw.museummanagment.Model.Item;
import pl.fundacjamhw.museummanagment.Model.ItemCollect;
import pl.fundacjamhw.museummanagment.Model.User;

import java.util.List;

public interface ItemCollectionRepo extends JpaRepository<ItemCollect,Long> {
    @Query("select i from ItemCollect i where i.user.id = ?1")
    List<ItemCollect> findByUser_Id(Long id);





}
