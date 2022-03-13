package first_try.server.controllers;

import first_try.server.dto.UserDto;
import first_try.server.entities.User;
import first_try.server.services.UserService;
import first_try.server.services.VacancyService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  public List<Map<Object, Object>> getAll(HttpServletResponse response) {
    List<Map<Object, Object>> users = new ArrayList<>();
    userService.getAll().forEach(user -> {
      Map<Object, Object> tmp = new HashMap<>();
      tmp.put("id", user.getId());
      tmp.put("username", user.getUsername());
      tmp.put("vacancy", user.getVacancy().getName());
      tmp.put("url", user.getPathToVideo());
      users.add(tmp);
    });
    return users;
  }

  @PostMapping
  public void create(HttpServletResponse response, @RequestBody UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setVacancy(vacancyService.findById(userDto.getVid()));
    userService.create(user);
  }
}
