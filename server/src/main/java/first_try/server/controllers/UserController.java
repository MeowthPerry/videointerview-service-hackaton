package first_try.server.controllers;

import first_try.server.entities.Question;
import first_try.server.entities.User;
import first_try.server.services.UserService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user/")
public class UserController {
  @Autowired private UserService userService;

  @GetMapping("{id}")
  public ResponseEntity<Map<Object, Object>> getCandidateInfo(
      @PathVariable Long id, HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
    Map<Object, Object> map = new HashMap<>();
    User user = userService.getById(id);
    map.put("name", user.getUsername());
    map.put("vacancy", user.getVacancy().getName());
    map.put("questions", user.getVacancy().getQuestions().stream().map(Question::getContent).collect(
        Collectors.toList()));
    return ResponseEntity.ok(map);
  }

  @PostMapping("/{id}/save")
  public void saveAnswers(@PathVariable Long id, @RequestBody String request, HttpServletResponse response) throws IOException {
    log.info("saving video");
    response.addHeader("Access-Control-Allow-Origin", "*");
    request = request.substring(37);
    log.info(request);
    byte[] data = Base64.decodeBase64(request);
    try (OutputStream stream = new FileOutputStream("C:/Users/ikhab/images/" + id + ".webm")) {
      stream.write(data);
    }
    User user = userService.getById(id);
    user.setPathToVideo("C:/Users/ikhab/images/" + id + ".webm ");
    userService.update(user);
  }
}
