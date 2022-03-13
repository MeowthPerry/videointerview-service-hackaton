package first_try.server.controllers;

import first_try.server.dto.UserDto;
import first_try.server.entities.User;
import first_try.server.services.UserService;
import first_try.server.services.VacancyService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/user")
public class AdminUserController {
  @Autowired private UserService userService;
  @Autowired private VacancyService vacancyService;

  @GetMapping
  public List<User> getAll(HttpServletResponse response) {
    return userService.getAll();
  }

  @PostMapping
  public void create(HttpServletResponse response, @RequestBody UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setVacancy(vacancyService.findById(userDto.getVid()));
    userService.create(user);
  }
}
