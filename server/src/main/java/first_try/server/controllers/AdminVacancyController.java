package first_try.server.controllers;

import first_try.server.entities.Vacancy;
import first_try.server.services.VacancyService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/vacancy/")
public class AdminVacancyController {
  @Autowired private VacancyService vacancyService;

  @GetMapping
  public ResponseEntity<List<Vacancy>> getAll(HttpServletRequest request) {
    return ResponseEntity.ok(vacancyService.getAll());
  }
}
