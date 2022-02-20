package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fundacjamhw.museummanagment.Model.Items;
import pl.fundacjamhw.museummanagment.Model.Users;
import pl.fundacjamhw.museummanagment.Repository.ItemsRepo;
import pl.fundacjamhw.museummanagment.Repository.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public List<Users> getItemsList(){
        return userRepo.findAll();
    }
}
