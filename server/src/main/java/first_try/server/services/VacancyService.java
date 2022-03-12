package first_try.server.services;

import first_try.server.entities.Vacancy;
import first_try.server.repositories.VacancyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyService {
  @Autowired VacancyRepository vacancyRepository;

  public List<Vacancy> getAll() {
    return vacancyRepository.findAll();
  }
}
