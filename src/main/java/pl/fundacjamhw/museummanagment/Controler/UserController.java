package pl.fundacjamhw.museummanagment.Controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.fundacjamhw.museummanagment.Model.ERole;
import pl.fundacjamhw.museummanagment.Model.Role;
import pl.fundacjamhw.museummanagment.Model.User;
import pl.fundacjamhw.museummanagment.Repository.RoleRepository;
import pl.fundacjamhw.museummanagment.Repository.UserRepo;
import pl.fundacjamhw.museummanagment.Service.UserService;
import pl.fundacjamhw.museummanagment.payload.request.SignupRequest;
import pl.fundacjamhw.museummanagment.payload.response.MessageResponse;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserRepo userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    @GetMapping("/users")
    public List<User> getItems() {
        return userService.getItemsList();
    }
    @PostMapping("/user" )
    public ResponseEntity<User> addNewItems(@RequestBody User user){
        return ResponseEntity.of(userService.addUser(user));

    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }


        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),signUpRequest.getFirstName(), signUpRequest.getLastName());
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
