package vlezana.example.subscriber.domain.service;


import vlezana.example.domain.model.BookingDto;
import vlezana.example.domain.model.BookingMessage;

import java.util.List;

public interface BookingService {

    void save(BookingMessage dto);

    List<BookingDto> getBookings();
}
