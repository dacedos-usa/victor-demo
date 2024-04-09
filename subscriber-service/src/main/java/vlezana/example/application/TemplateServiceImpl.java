package vlezana.example.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import vlezana.example.domain.model.SaltDto;
import vlezana.example.domain.service.TemplateService;
import vlezana.example.template.TemplateRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository repository;

    private final JmsTemplate mqJmsTemplate;

    @Value("${active-mq.topic:dacedos}")
    private String topic;

    @Override
    public void save(SaltDto message) {
        try {
            log.info("Attempting to save message to mongo: " + message.getEventId());
            repository.save(message);
        } catch (Exception e) {
            log.error("Received Exception from mongoDB: ", e);
        }
    }

}
