package pl.fundacjamhw.museummanagment.Controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fundacjamhw.museummanagment.Model.Item;
import pl.fundacjamhw.museummanagment.Model.ItemCollect;
import pl.fundacjamhw.museummanagment.Service.GetItemsService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class itemCollection {
    private final GetItemsService getItemsService;


    @GetMapping("/getItems")
    public List<ItemCollect> getItemsList(){
        return getItemsService.getItemsListList();
    }

    @PostMapping("/getItems")
    public ResponseEntity<ItemCollect> addNewItems(@RequestBody ItemCollect itemCollectem){
        return ResponseEntity.of(getItemsService.getItemFromMuseum(itemCollectem));


    }
}
