package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fundacjamhw.museummanagment.Model.Item;
import pl.fundacjamhw.museummanagment.Repository.ItemsRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService  {
    private final ItemsRepo itemsRepo;
    public List<Item> getItemsList(){
        return itemsRepo.findAll();
    }
    public Optional<Item> addNewItems(Item item){
        item.setName(item.getName());
        item.setNumberOfItems(item.getNumberOfItems());
        return Optional.of(itemsRepo.save(item));
    }

}
