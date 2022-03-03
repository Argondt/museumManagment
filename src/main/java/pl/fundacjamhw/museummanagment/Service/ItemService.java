package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fundacjamhw.museummanagment.Model.Item;
import pl.fundacjamhw.museummanagment.Repository.ItemsRepo;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemsRepo itemsRepo;

    public List<Item> getItemsList() {
        return itemsRepo.findAll();
    }

    public Optional<Item> addNewItems(Item item) {
        item.setName(item.getName());
        item.setNumberOfItems(item.getNumberOfItems());
        return Optional.of(itemsRepo.save(item));
    }

    public Optional<Item> getItemById(Long id) {
        return itemsRepo.findById(id);
    }

    @Transactional
    //Poprawić nazwę
    public Item updateInventory(Long id, int tmpInt) {
        Item item = itemsRepo.findById(id).orElseThrow(NoSuchElementException::new);
        if (item.getNumberOfItems() - tmpInt >= 0){
            item.setNumberOfItems(item.getNumberOfItems() - tmpInt );
        }
        else{
            //wyjątek
            System.out.println("Nie ma tyle przedmiotó");
        }
        return item;
    }

}
