package first_try.server.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vacancies")
@Data
public class Vacancy extends BaseEntity {
  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "vacancy")
  private List<Candidate> candidates;

  @OneToMany(mappedBy = "vacancy")
  private List<Question> questions;
}
