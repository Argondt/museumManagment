package pl.fundacjamhw.museummanagment.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.fundacjamhw.museummanagment.Model.User;
import pl.fundacjamhw.museummanagment.Repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
    private final UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getItemsList(){
        return userRepo.findAll();
    }
    public Optional<User> addUser(User user){
        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  Optional.of(userRepo.save(user));

    }
    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }

}
