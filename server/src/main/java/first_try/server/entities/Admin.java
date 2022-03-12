package first_try.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "admins")
@Data
public class Admin extends BaseEntity {
  @Column(name = "login")
  private String login;

  @Column(name = "password")
  private String password;
}
