package vlezana.example.producer.domain.service;

import vlezana.example.domain.model.BookingDto;
import vlezana.example.domain.model.BookingMessage;

public interface BookingService {

    BookingMessage publish(BookingDto dto);

}
