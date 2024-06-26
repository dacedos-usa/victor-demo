package vlezana.example.subscriber.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import vlezana.example.domain.model.BookingMessage;
import vlezana.example.subscriber.domain.service.BookingService;

@Component
@Slf4j
public class MqConsumer implements MessageListener {

    @Autowired
    private BookingService service;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Este es el punto de entrada de mensajes desde la cola, cuando se detecta que se ha publicado un mensaje, este metodo lo lee.
     * Este metodo recibe un mensaje como texto y lo convierte a nuestro objeto.
     * Llama al BookingServiceImpl para guardar en Mongo
     * @param message the message passed to the listener
     */
    @Override
    @JmsListener(destination = "${queue.name}")
    public void onMessage(Message message) {
        try{
            log.info("Received Message from Topic: "+ message.getJMSMessageID());
            TextMessage objectMessage = (TextMessage)message;
            BookingMessage reservation = objectMapper.readValue(objectMessage.getText(), BookingMessage.class);
            log.info("Received Message from Topic: "+ reservation.toString());
            service.save(reservation);
            //do additional processing
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }

    }
}
