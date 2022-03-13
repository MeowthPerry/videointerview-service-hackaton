package first_try.server.config;

import first_try.server.filters.AdminFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringConfig {

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public FilterRegistrationBean<AdminFilter> adminFilter() {
    FilterRegistrationBean<AdminFilter> registrationBean
        = new FilterRegistrationBean<>();
    registrationBean.setFilter(new AdminFilter());
    registrationBean.addUrlPatterns("/api/admin/*");
    return registrationBean;
  }
}
