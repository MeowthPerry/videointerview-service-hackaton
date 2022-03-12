package first_try.server.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
  private String login;
  private String password;
}
