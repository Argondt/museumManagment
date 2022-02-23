package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fundacjamhw.museummanagment.Model.ItemCollect;
import pl.fundacjamhw.museummanagment.Repository.ItemCollectionRepo;
import pl.fundacjamhw.museummanagment.Repository.ItemsRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetItemsService {
    private final ItemCollectionRepo ItemCollectionRepo;
    private final ItemsRepo itemRepo;

    public List<ItemCollect> getItemsListList(){
        return ItemCollectionRepo.findAll();
    }

    public ItemCollect getItemFromMuseum(ItemCollect itemCollect){
        itemCollect.setItemName(itemCollect.getItemName());
        itemCollect.setTakenSize(itemCollect.getTakenSize());
        itemCollect.setItem(itemCollect.getItem());
        itemCollect.setUser(itemCollect.getUser());

        return ItemCollectionRepo.save(itemCollect);
    }


}
