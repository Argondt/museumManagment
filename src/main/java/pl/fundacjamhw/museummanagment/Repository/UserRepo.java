package pl.fundacjamhw.museummanagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fundacjamhw.museummanagment.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
