package pl.fundacjamhw.museummanagment.Controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fundacjamhw.museummanagment.Model.Item;
import pl.fundacjamhw.museummanagment.Service.ItemService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class ItemsController{

    private final ItemService itemService;


    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getItemsList();
    }

    @PostMapping("/items")
    public ResponseEntity<Item> addNewItems(@RequestBody Item item){
        return ResponseEntity.of(itemService.addNewItems(item));

    }

}
