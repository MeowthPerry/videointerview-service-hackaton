package first_try.server.services;

import first_try.server.entities.User;
import first_try.server.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User getById(Long id) {
    return userRepository.getById(id);
  }

  public void create(User user) {
    userRepository.save(user);
  }

  public void update(User user) {
    userRepository.save(user);
  }
}
