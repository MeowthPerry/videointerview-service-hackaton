package first_try.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "questions")
@Data
public class Question extends BaseEntity {
  @Column(name = "data")
  private String content;

  @ManyToOne
  @JoinColumn(name = "vacancy_id", nullable = false)
  private Vacancy vacancy;
}
