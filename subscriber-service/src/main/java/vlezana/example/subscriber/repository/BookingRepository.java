package vlezana.example.subscriber.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import vlezana.example.domain.model.BookingMessage;

public interface BookingRepository extends MongoRepository<BookingMessage, String> {

}
