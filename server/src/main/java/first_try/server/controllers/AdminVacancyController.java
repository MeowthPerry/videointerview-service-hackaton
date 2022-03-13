package first_try.server.controllers;

import first_try.server.dto.VacancyDto;
import first_try.server.entities.Vacancy;
import first_try.server.services.VacancyService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/admin/vacancy/")
public class AdminVacancyController {
  @Autowired private VacancyService vacancyService;

  @GetMapping
  public ResponseEntity<List<Vacancy>> getAll(HttpServletRequest request) {
    return ResponseEntity.ok(vacancyService.getAll());
  }

  @PostMapping
  public void save(HttpServletRequest request, @RequestBody VacancyDto vacancyDto) {
    vacancyService.save(vacancyDto.toVacancy());
  }

  @DeleteMapping("{id}")
  public void delete(HttpServletRequest request, @PathVariable Long id) {
    vacancyService.delete(id);
  }
}
