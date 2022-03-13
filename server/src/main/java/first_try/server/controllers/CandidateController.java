package first_try.server.controllers;

import first_try.server.services.CandidateService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/candidate/")
public class CandidateController {
  @Autowired private CandidateService candidateService;
  @Autowired private ServletContext servletContext;

  @GetMapping("{id}")
  public ResponseEntity<Map<Object, Object>> getCandidateInfo(
      @PathVariable Long id, HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
    Map<Object, Object> map = new HashMap<>();
    Candidate candidate = candidateService.getById(id);
    map.put("name", candidate.getName());
    map.put("vacancy", candidate.getVacancy().getName());
    map.put("questions", candidate.getVacancy().getQuestions().stream().map(question -> {return question.getContent();}).collect(
        Collectors.toList()));
    return ResponseEntity.ok(map);
  }

  @PostMapping("/{id}/save")
  public void saveAnswers(@RequestBody String request, HttpServletResponse response) throws IOException {
    log.info("saving video");
    response.addHeader("Access-Control-Allow-Origin", "*");
    request = request.substring(37);
    log.info(request);
    byte[] data = Base64.decodeBase64(request);
    try (OutputStream stream = new FileOutputStream("C:/Users/ikhab/images/sample.webm ")) {
      stream.write(data);
    }
  }
}
