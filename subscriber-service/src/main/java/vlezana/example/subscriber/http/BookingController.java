package vlezana.example.subscriber.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vlezana.example.domain.model.BookingDto;
import vlezana.example.subscriber.domain.service.BookingService;

import java.util.List;

@RestController
@Slf4j
public class BookingController {

    @Autowired
    BookingService bookingService;


    /**
     * Controller, este es el punto de entrada de peticiones http, a este se le llama cuando mandas desde postman.
     * Este llama a BookingService (getBookings)
     * Devuelve la lista de reservas de 'este' hotel
     * @return
     */
    @GetMapping(value="/api/book")
    public List<BookingDto> getBookings(){
        return bookingService.getBookings();
    }

}
