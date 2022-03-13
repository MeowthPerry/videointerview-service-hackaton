package first_try.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {
  @Column(name = "username")
  private String username;

  @ManyToOne
  @JoinColumn(name = "vacancy_id")
  private Vacancy vacancy;

  @Column(name = "video")
  private String pathToVideo;
}
