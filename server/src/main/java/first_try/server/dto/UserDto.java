package first_try.server.dto;

import first_try.server.entities.User;
import lombok.Data;

@Data
public class UserDto {
  private String username;
  private Long vid;
}
