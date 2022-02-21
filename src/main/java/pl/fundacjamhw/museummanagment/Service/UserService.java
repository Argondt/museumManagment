package pl.fundacjamhw.museummanagment.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fundacjamhw.museummanagment.Model.User;
import pl.fundacjamhw.museummanagment.Repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public List<User> getItemsList(){
        return userRepo.findAll();
    }
    public Optional<User> addUser(User user){
        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        return  Optional.of(userRepo.save(user));

    }

}
