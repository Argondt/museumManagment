package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fundacjamhw.museummanagment.Model.Item;
import pl.fundacjamhw.museummanagment.Model.ItemCollect;
import pl.fundacjamhw.museummanagment.Model.User;
import pl.fundacjamhw.museummanagment.Repository.ItemCollectionRepo;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetItemsService {
    private final ItemCollectionRepo itemCollectionRepo;
    private final ItemService itemService;
    private final UserService userService;


    public List<ItemCollect> getItemsListList(){
        return itemCollectionRepo.findAll();
    }

    @Transactional
    public ItemCollect getItemFromMuseum(ItemCollect itemCollect){
        Item item = itemService.updateInventory(itemCollect.getItem().getId(), itemCollect.getNumberOfItemsTaken());
        itemCollect.setItem(item);
        User user = userService.getUserById(itemCollect.getUser().getId()).orElseThrow(NoSuchElementException::new);
        itemCollect.setUser(user);
        return itemCollectionRepo.save(itemCollect);
    }
    public Optional<ItemCollect> getItemFromMuseumById (Long id){
        return  itemCollectionRepo.findById(id);
    }

    public List<ItemCollect> listItemFromMuseumByUserId(Long userID){
        return itemCollectionRepo.findByUser_Id(userID);
    }
}
