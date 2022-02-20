package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fundacjamhw.museummanagment.Model.Items;
import pl.fundacjamhw.museummanagment.Repository.ItemsRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService  {
    private final ItemsRepo itemsRepo;
    public List<Items> getItemsList(){
        return itemsRepo.findAll();
    }

}
