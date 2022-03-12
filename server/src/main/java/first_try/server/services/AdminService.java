package first_try.server.services;

import first_try.server.entities.Admin;
import first_try.server.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
  @Autowired private AdminRepository adminRepository;

  public Admin findByLogin(String login) {
    return adminRepository.findByLogin(login);
  }
}
