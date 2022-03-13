package first_try.server.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class AdminFilter implements Filter {
  @Value("${admin.key}")
  private String key = "secret";

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    log.info(request.getHeader("Key"));
    log.info(key);
    if (request.getHeader("Key").equals(key))
      filterChain.doFilter(servletRequest, servletResponse);
    else
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
  }
}
