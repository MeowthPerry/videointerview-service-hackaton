package first_try.server.dto;

import first_try.server.entities.User;

public class UserDto {
  private String username;

  public User toUser() {
    User user = new User();
    user.setUsername(username);
    return user;
  }
}
