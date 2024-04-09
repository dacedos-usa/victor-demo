package vlezana.example.listener;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import vlezana.example.domain.model.SaltDto;
import vlezana.example.domain.service.TemplateService;

@Component
@Slf4j
public class MqConsumer implements MessageListener {

    @Autowired
    private TemplateService service;

    @Override
    @JmsListener(destination = "sms-updates")
    public void onMessage(Message message) {
        try{
            log.info("Received Message from Topic: "+ message.toString());
            ObjectMessage objectMessage = (ObjectMessage)message;
            SaltDto saltDto = (SaltDto)objectMessage.getObject();
            log.info("Received Message from Topic: "+ saltDto.toString());
            service.save(saltDto);
            //do additional processing
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }

    }
}
