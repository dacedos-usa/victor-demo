package vlezana.example.template;

import org.springframework.data.mongodb.repository.MongoRepository;
import vlezana.example.domain.model.SaltDto;

public interface TemplateRepository extends MongoRepository<SaltDto, String> {

}
