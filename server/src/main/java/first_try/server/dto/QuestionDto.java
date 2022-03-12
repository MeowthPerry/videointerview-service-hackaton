package first_try.server.dto;

import first_try.server.entities.Question;
import lombok.Data;

@Data
public class QuestionDto {
  private String content;

  public Question toQuestion() {
    Question question = new Question();
    question.setContent(this.content);
    return question;
  }
}
