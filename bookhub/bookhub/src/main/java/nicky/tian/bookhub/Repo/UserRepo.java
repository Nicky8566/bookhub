package nicky.tian.bookhub.Repo;

import nicky.tian.bookhub.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    // custom method that MongoDB will make based on its naming conventions
    Optional<User> findByEmail(String email);
}