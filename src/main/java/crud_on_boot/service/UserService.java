package crud_on_boot.service;

import crud_on_boot.model.User;
import crud_on_boot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    public UserService(UserRepository repository) { this.repository = repository; }


    public List<User> getAllUsers() {
     return repository.findAll();
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public User getUserById(Long id) {
        return repository.getOne(id);
    }
}
