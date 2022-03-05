package pl.fundacjamhw.museummanagment.Controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fundacjamhw.museummanagment.Model.Item;
import pl.fundacjamhw.museummanagment.Model.User;
import pl.fundacjamhw.museummanagment.Service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getItems() {
        return userService.getItemsList();
    }
    @PostMapping("/user" )
    public ResponseEntity<User> addNewItems(@RequestBody User user){
        return ResponseEntity.of(userService.addUser(user));

    }

}
