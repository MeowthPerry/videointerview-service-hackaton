package first_try.server.services;

import first_try.server.entities.Question;
import first_try.server.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
  @Autowired QuestionRepository questionRepository;

  public void save(Question question) {
    questionRepository.save(question);
  }

  public void update(Question question) { questionRepository.save(question); }

  public void delete(Long id) { questionRepository.deleteById(id); }
}
