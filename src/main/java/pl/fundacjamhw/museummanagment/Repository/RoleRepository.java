package pl.fundacjamhw.museummanagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fundacjamhw.museummanagment.Model.ERole;
import pl.fundacjamhw.museummanagment.Model.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}