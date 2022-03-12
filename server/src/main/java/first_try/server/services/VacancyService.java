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

  public Vacancy findById(Long id) {
    return vacancyRepository.getById(id);
  }

  public void save(Vacancy vacancy) {
    vacancyRepository.save(vacancy);
  }
}
