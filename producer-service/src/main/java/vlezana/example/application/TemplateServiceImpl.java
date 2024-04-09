package vlezana.example.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import vlezana.example.domain.model.SaltDto;
import vlezana.example.domain.service.TemplateService;

@Slf4j
@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final JmsTemplate mqJmsTemplate;

    @Value("${queue.topic:sms-updates}")
    private String topic;

    @Override
    public void publish(SaltDto message) {
        try {
            log.info("Attempting Send message to Topic: " + topic);
            mqJmsTemplate.convertAndSend(topic, message);
        } catch (Exception e) {
            log.error("Recieved Exception during send Message: ", e);
        }
    }

}
