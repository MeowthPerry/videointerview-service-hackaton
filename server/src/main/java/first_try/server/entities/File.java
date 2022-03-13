package first_try.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "files")
@Data
public class File extends BaseEntity {
  @Column(name = "path")
  private String path;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
