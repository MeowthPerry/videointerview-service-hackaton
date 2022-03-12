package first_try.server.services;

import first_try.server.entities.Candidate;
import first_try.server.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
  @Autowired CandidateRepository candidateRepository;

  public Candidate getById(Long id) {
    return candidateRepository.getById(id);
  }
}
