package pl.fundacjamhw.museummanagment.Controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fundacjamhw.museummanagment.Model.getItems;
import pl.fundacjamhw.museummanagment.Service.GetItemsService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class getItemsController {
    private final GetItemsService getItemsService;

    @GetMapping("/getItems")
    public List<getItems> getItemsList(){
        return getItemsService.getItemsListList();
    }

}
