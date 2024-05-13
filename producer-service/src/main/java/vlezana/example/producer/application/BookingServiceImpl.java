package vlezana.example.producer.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import vlezana.example.domain.model.BookingMessage;
import vlezana.example.producer.domain.service.BookingService;
import vlezana.example.domain.model.BookingDto;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final JmsTemplate mqJmsTemplate;
    private final ObjectMapper objectMapper;

    /**
     * Implementación del metodo Publish del Booking service. Se le llama desde el controller
     * Obtiene el topic desde el payload
     * Genera el mensaje
     * Envía el mensaje utilizando el mqJmsTemplate que es parte de la librería de JMS de SpringBoot
     * @param payload
     * @return
     */
    @Override
    public BookingMessage publish(BookingDto payload) {
        try {
            var destination = payload.getProperty();
            var message = BookingMessage.builder()
                    .eventId(UUID.randomUUID().toString())
                    .timestamp(LocalDateTime.now().toString())
                    .eventType("book")
                    .payload(payload)
                    .build();

            log.info("Attempting Send message to Topic: " + destination);
            mqJmsTemplate.convertAndSend(destination, objectMapper.writeValueAsString(message));
            return message;
        } catch (Exception e) {
            log.error("Received Exception during send Message: ", e);
            return null;
        }
    }

}
