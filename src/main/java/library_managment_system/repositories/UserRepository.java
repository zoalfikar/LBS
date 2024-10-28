package library_managment_system.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import library_managment_system.models.User;



public interface UserRepository extends CrudRepository<User, Long > {

    Optional<User> findByEmail(String email);

}
