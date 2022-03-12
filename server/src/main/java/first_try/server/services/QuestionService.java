package first_try.server.services;

import first_try.server.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionService {
  @Autowired QuestionRepository questionRepository;
}
