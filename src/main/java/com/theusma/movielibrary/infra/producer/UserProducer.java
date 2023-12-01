package com.theusma.movielibrary.infra.producer;

import com.theusma.movielibrary.domain.user.EmailRequest;
import com.theusma.movielibrary.domain.user.UserRegisterDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${spring.rabbitmq.queue}")
    private String routingKey;

    public void publishMessageEmail(EmailRequest emailRequest) {
        rabbitTemplate.convertAndSend("", routingKey, emailRequest);
    }

}