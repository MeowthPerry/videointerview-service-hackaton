package first_try.server.controllers;

import first_try.server.dto.AuthenticationRequestDto;
import first_try.server.entities.Admin;
import first_try.server.security.JwtTokenProvider;
import first_try.server.services.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/auth/")
public class AdminAuthController {
  private final JwtTokenProvider jwtTokenProvider;
  private final AdminService adminService;
  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public AdminAuthController(
      JwtTokenProvider jwtTokenProvider,
      AdminService adminService,
      BCryptPasswordEncoder passwordEncoder) {
    this.jwtTokenProvider = jwtTokenProvider;
    this.adminService = adminService;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("login")
  public ResponseEntity<String> login(@RequestBody AuthenticationRequestDto requestDto) {
    String login = requestDto.getLogin();
    Admin admin = adminService.findByLogin(login);
    if (admin == null) {
      throw new UsernameNotFoundException("Admin with login: " + login + " not found");
    }
    if (!passwordEncoder.matches(requestDto.getPassword(), admin.getPassword())) {
      log.info("{}", requestDto.getPassword());
      log.info("{}", admin.getPassword());
      log.error("Invalid login or password");
      throw new BadCredentialsException("Invalid login or password");
    }
    String token = jwtTokenProvider.createToken(login);
    return ResponseEntity.ok(token);
  }
}
