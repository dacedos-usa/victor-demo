package vlezana.example.producer.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vlezana.example.domain.model.BookingDto;
import vlezana.example.domain.model.BookingMessage;
import vlezana.example.producer.domain.service.BookingService;

@RestController
@Slf4j
public class ProduceMessageController {

    @Autowired
    BookingService mqProducer;

    /**
     * Controller, este es el punto de entrada de peticiones http, a este se le llama cuando mandas desde postman.
     * Este llama a BookingService (mqProducer)
     * @param dto
     * @return
     */
    @PostMapping(value="/api/book")
    public BookingMessage sendMessageMq(@RequestBody BookingDto dto){
        var message = mqProducer.publish(dto);
        return message;
    }

}
