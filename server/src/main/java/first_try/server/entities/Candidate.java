package first_try.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "candidates")
@Data
public class Candidate extends BaseEntity {
  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "vacancy_id")
  private Vacancy vacancy;
}
