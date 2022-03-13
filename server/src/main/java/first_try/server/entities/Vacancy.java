package first_try.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vacancies")
@Data
public class Vacancy extends BaseEntity {
  @Column(name = "name")
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "vacancy", fetch = FetchType.LAZY)
  private List<User> users;

  @OneToMany(mappedBy = "vacancy")
  private List<Question> questions;
}
