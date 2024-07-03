package nicky.tian.bookhub.Service;
import nicky.tian.bookhub.Entity.User;
import nicky.tian.bookhub.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveOrUpdate(User user) {
        // saves user to MongoDB database
        userRepo.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        // retrieves the entity with the given email from the MongoDB database
        return userRepo.findByEmail(email);
    }

    public Optional<User> Id(String ID) {
        // retrieves the entity with the given ID from the MongoDB database
        return userRepo.findById(ID);
    }

    public void deleteUser(String id) {
        // deletes the entity with the given ID from the MongoDB database
        userRepo.deleteById(id);
    }

    public void deleteAllUsers() {
        // deletes all entities from the MongoDB database
        userRepo.deleteAll();
    }

    // use find all to retrieve all entitys 
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }
}