package first_try.server.controllers;

import first_try.server.dto.QuestionDto;
import first_try.server.entities.Question;
import first_try.server.services.QuestionService;
import first_try.server.services.VacancyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/admin/vacancy/{id}/question/")
public class AdminQuestionController {
  @Autowired private VacancyService vacancyService;
  @Autowired private QuestionService questionService;

  @PostMapping
  public void save(@PathVariable Long id, @RequestBody QuestionDto questionDto) {
    Question question = questionDto.toQuestion();
    question.setVacancy(vacancyService.findById(id));
    questionService.save(question);
  }

  @PutMapping
  public void update(@PathVariable Long id, @RequestBody QuestionDto questionDto)
  {
    Question question = questionDto.toQuestion();
    question.setVacancy(vacancyService.findById(id));
    questionService.update(question);
  }

  @DeleteMapping
  public void delete(@PathVariable Long id)
  {
    questionService.delete(id);
  }
}
