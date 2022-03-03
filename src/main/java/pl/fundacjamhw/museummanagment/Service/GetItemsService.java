package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fundacjamhw.museummanagment.Model.Item;
import pl.fundacjamhw.museummanagment.Model.ItemCollect;
import pl.fundacjamhw.museummanagment.Model.User;
import pl.fundacjamhw.museummanagment.Repository.ItemCollectionRepo;
import pl.fundacjamhw.museummanagment.Repository.ItemsRepo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetItemsService {
    private final ItemCollectionRepo ItemCollectionRepo;
    private final ItemService itemService;
    private final UserService userService;


    public List<ItemCollect> getItemsListList(){
        return ItemCollectionRepo.findAll();
    }

    @Transactional
    public ItemCollect getItemFromMuseum(ItemCollect itemCollect){
        Item item = itemService.updateInventory(itemCollect.getItem().getId(), itemCollect.getNumberOfItemsTaken());
        itemCollect.setItem(item);
        User user = userService.getUserById(itemCollect.getUser().getId()).orElseThrow(NoSuchElementException::new);
        itemCollect.setUser(user);
        return ItemCollectionRepo.save(itemCollect);
    }
    public Optional<ItemCollect> getItemFromMuseumById (Long id){
        return  ItemCollectionRepo.findById(id);
    }
}
