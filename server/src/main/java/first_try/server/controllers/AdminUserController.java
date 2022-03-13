package first_try.server.controllers;

import first_try.server.entities.User;
import first_try.server.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/user/")
public class AdminUserController {
  @Autowired private UserService userService;

  @GetMapping
  public List<User> getAll() {
    return userService.getAll();
  }
}
