package first_try.server.services;

import first_try.server.entities.User;
import first_try.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public User getById(Long id) {
    return userRepository.getById(id);
  }
}
