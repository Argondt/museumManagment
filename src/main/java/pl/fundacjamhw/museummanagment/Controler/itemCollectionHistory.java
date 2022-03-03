package pl.fundacjamhw.museummanagment.Controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.fundacjamhw.museummanagment.Model.ItemCollect;
import pl.fundacjamhw.museummanagment.Service.GetItemsService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class itemCollectionHistory {
    private final GetItemsService getItemsService;


    @GetMapping("/items-history")
    public List<ItemCollect> getItemsList() {
        return getItemsService.getItemsListList();
    }

    @PostMapping("/items-history")
    public ItemCollect addNewItems(@RequestBody ItemCollect itemCollectem) {
        return getItemsService.getItemFromMuseum(itemCollectem);
    }
    @GetMapping("/items-history/{id}")
    public Optional<ItemCollect> getItemFromMuseumById(@PathVariable Long id){
        return getItemsService.getItemFromMuseumById(id);
    }



}
