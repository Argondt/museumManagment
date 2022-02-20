package pl.fundacjamhw.museummanagment.Controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fundacjamhw.museummanagment.Model.Items;
import pl.fundacjamhw.museummanagment.Model.Users;
import pl.fundacjamhw.museummanagment.Service.ItemService;
import pl.fundacjamhw.museummanagment.Service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<Users> getItems() {
        return userService.getItemsList();
    }
}
