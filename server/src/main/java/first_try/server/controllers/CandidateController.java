package first_try.server.controllers;

import first_try.server.entities.Candidate;
import first_try.server.services.CandidateService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/candidate/")
public class CandidateController {
  @Autowired private CandidateService candidateService;

  @GetMapping("{id}")
  public ResponseEntity<Map<Object, Object>> getCandidateInfo(@PathVariable Long id, HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
    Map<Object, Object> map = new HashMap<>();
    Candidate candidate = candidateService.getById(id);
    map.put("name", candidate.getName());
    map.put("vacancy", candidate.getVacancy().getName());
    map.put("questions", candidate.getVacancy().getQuestions());
    return ResponseEntity.ok(map);
  }
}
