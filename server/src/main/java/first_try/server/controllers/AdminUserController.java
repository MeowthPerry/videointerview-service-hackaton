package first_try.server.controllers;

import first_try.server.dto.UserDto;
import first_try.server.entities.User;
import first_try.server.services.UserService;
import first_try.server.services.VacancyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/user/")
public class AdminUserController {
  @Autowired private UserService userService;
  @Autowired private VacancyService vacancyService;

  @GetMapping
  public List<User> getAll() {
    return userService.getAll();
  }

  @PostMapping
  public void create(@RequestBody UserDto userDto, @RequestBody Long vid) {
    User user = userDto.toUser();
    user.setVacancy(vacancyService.findById(vid));
    userService.create(user);
  }
}
