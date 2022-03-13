package first_try.server.services;

import first_try.server.entities.Admin;
import first_try.server.entities.User;
import first_try.server.repositories.AdminRepository;
import first_try.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired private UserRepository adminRepository;

  public User findByLogin(String login) {
    return adminRepository.findByLogin(login);
  }
}
