package first_try.server.services;

import first_try.server.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FileService {
  @Autowired FileRepository fileRepository;
}
