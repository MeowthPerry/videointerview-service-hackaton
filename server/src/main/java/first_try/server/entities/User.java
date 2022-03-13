package first_try.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "admins")
@Data
public class User extends BaseEntity {
  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;
}
