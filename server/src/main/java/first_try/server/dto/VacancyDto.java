package first_try.server.dto;

import first_try.server.entities.Vacancy;
import lombok.Data;

@Data
public class VacancyDto {
  private String name;

  public Vacancy toVacancy() {
    Vacancy vacancy = new Vacancy();
    vacancy.setName(this.getName());
    return vacancy;
  }
}
