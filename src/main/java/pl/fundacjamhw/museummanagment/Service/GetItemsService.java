package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fundacjamhw.museummanagment.Model.getItems;
import pl.fundacjamhw.museummanagment.Repository.getItemsRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetItemsService {
    private final getItemsRepo getItemsRepo;

    public List<getItems> getItemsListList(){
        return getItemsRepo.findAll();
    }
}
