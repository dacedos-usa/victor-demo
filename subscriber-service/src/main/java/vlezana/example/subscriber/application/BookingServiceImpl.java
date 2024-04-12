package vlezana.example.subscriber.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vlezana.example.domain.model.BookingDto;
import vlezana.example.domain.model.BookingMessage;
import vlezana.example.subscriber.domain.service.BookingService;
import vlezana.example.subscriber.repository.BookingRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    @Override
    public void save(BookingMessage message) {
        try {
            log.info("Attempting to save message to mongo: " + message.getEventId());
            message.getPayload().setCreated(LocalDateTime.now());
            repository.save(message);
        } catch (Exception e) {
            log.error("Received Exception from mongoDB: ", e);
        }
    }

    @Override
    public List<BookingDto> getBookings() {
        return repository.findAll().stream().map(BookingMessage::getPayload).toList();
    }

}
