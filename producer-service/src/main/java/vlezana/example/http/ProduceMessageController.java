package vlezana.example.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vlezana.example.domain.model.SaltDto;
import vlezana.example.domain.service.TemplateService;

@RestController
@Slf4j
public class ProduceMessageController {

    @Autowired
    TemplateService mqProducer;

    @PostMapping(value="/api/mq")
    public SaltDto sendMessageMq(@RequestBody SaltDto message){
        mqProducer.publish(message);
        return message;
    }

}
